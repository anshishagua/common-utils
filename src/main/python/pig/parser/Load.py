from Node import Node
import GlobalContext
import re
import pig.config as config
import json
from Field import Field
from RelationField import SimpleField
import GlobalContext
from SimpleRelation import SimpleRelation

SCHEMA_PATH_MAPPING = {
    'o': 'oss',
    'd': 'dimension',
    'f': 'fact',
    'p': 'migration',
    'i': 'interface',
    'm': 'maintenance',
    'a': 'olap',
    's': 'snapshot',
}


class Load(Node):
    def __init__(self, schema):
        self.schema = schema
        self.type = "LOAD"
        self.children = []
        self.relation = None
        self.fields = []

    def get_relation(self):
        return self.relation

    def get_schema(self):
        return self.schema

    def is_relation_op(self):
        return True

    def __str__(self):
        return "[type:%s, relation:%s, schema:%s]" % (self.type, self.relation, self.schema)

    def parse_relation(self, exec_context):
        schema_root_path = config.SCHEMA_ROOT_PATH

        schema_file_name = self.schema

        if "|" in schema_file_name:
            schema_file_name = schema_file_name.split("|")[0]
        elif ":" in schema_file_name:
            schema_file_name = schema_file_name.split(":")[0]

        schema_file_name = schema_file_name.lower()

        postfix = schema_file_name.split("_")[-1]

        schema_file_path = schema_root_path + SCHEMA_PATH_MAPPING[postfix] + "/" + schema_file_name + ".schema"

        json_string = ""

        f = open(schema_file_path)
        for line in f:
            json_string += line + " "

        json_object = json.loads(json_string)

        fields = []

        for line in json_object["schema"]:
            field_name, data_type = line.split(":")
            fields.append(SimpleField(field_name, data_type, None))

        self.fields = fields

        return SimpleRelation(self.schema, fields)

    def to_spark(self, exec_context):
        self.relation = self.parse_relation(exec_context)
        schema = self.schema

        params = re.findall("\$[a-zA-Z0-9_]+", schema)

        param_values = []

        for param in params:
            key = param[1:]
            schema = schema.replace(param, "%s")
            param_values.append("str(params['%s'])" % (key))

        if param_values:
            schema = "'" + schema + "' % (" + ", ".join(param_values) + ")"
        else:
            schema = "'" + schema + "'"

        return "load_data_to_spark_dataframe(sc, %s, params)" % (schema)

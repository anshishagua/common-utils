import json
import os


class Field(object):
    def __init__(self, name, data_type):
        self.name = name
        self.data_type = data_type

    def __str__(self):
        return "%s:%s" % (self.name, self.data_type)


class Relation(object):
    def __init__(self, fields):
        self.fields = fields

    def __str__(self):
        return "[%s]" % (", ".join(map(str, self.fields)))

    @staticmethod
    def parse(path):
        string = ""
        f = open(path)

        for line in f:
            string += line + "\n"

        schema = json.loads(string)["schema"]

        fields = []

        for field in schema:
            name, type = field.split(":")
            fields.append(Field(name, type))


        return Relation(fields)


relation = Relation.parse("/Users/xiaoli/IdeaProjects/aardvark-analyze/statistics/marketing/schema/definitions/fact/ios_capi_pre_ingest_log_f.schema")

print relation

print os.environ["PYTHONPATH"]

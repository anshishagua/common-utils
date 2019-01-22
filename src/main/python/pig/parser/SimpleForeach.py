from Node import Node
from FieldRange import FieldRange
from Field import Field, ALL_FIELD
from ComplexRelation import ComplexRelation
from SimpleRelation import SimpleRelation
from Assign import Assign
from Flatten import Flatten


class SimpleForeach(Node):
	def __init__(self, src, generate_items):
		self.src = src
		self.generate_items = generate_items
		self.fields = []
		self.type = "SIMPLE_FOREACH"
		self.children = [src, generate_items]

	def __str__(self):
		return "FOREACH:%s = for %s, generate:%s" % (self.target, self.src, ", ".join(map(str, self.genItems)))

	def to_spark(self, exec_context):
		generate_items = []

		source_code = []

		if isinstance(self.src, ComplexRelation):
			temp_table_name = "temp_table"
			statement = Assign(SimpleRelation(temp_table_name), self.src)
			source_code.append(statement.to_spark(exec_context))
			self.src = SimpleRelation(temp_table_name)

		exec_context.params["relation_name"] = self.src.name
		for generate_item in self.generate_items:
			if isinstance(generate_item, FieldRange):
				items = generate_item.to_spark(exec_context)

				for item in items:
					generate_items.append(item.to_spark(exec_context))
					self.fields.append(item)
			elif isinstance(generate_item, Field) and generate_item == ALL_FIELD:
				items = exec_context.relation_map[self.src.name]

				for item in items:
					generate_items.append(item.to_spark(exec_context))
					self.fields.append(item)
			else:
				generate_items.append(generate_item.to_spark(exec_context))

				if isinstance(generate_item, Field):
					self.fields.append(generate_item)
				elif isinstance(generate_item, Flatten):
					self.fields.append(generate_item.as_fields)
				else:
					self.fields.append(generate_item.name)

		source_code.append("%s.select(%s)" % (self.src.to_spark(exec_context), ", ".join(generate_items)))

		return source_code

from Node import Node
from FieldRange import FieldRange
from Field import Field, ALL_FIELD


class SimpleForeach(Node):
	def __init__(self, src, generate_items):
		self.src = src
		self.generate_items = generate_items
		self.fields = []
		self.type = "SIMPLE_FOREACH"

	def __str__(self):
		return "FOREACH:%s = for %s, generate:%s" % (self.target, self.src, ", ".join(map(str, self.genItems)))

	def to_spark(self, exec_context):
		generate_items = []

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
				else:
					self.fields.append(generate_item.name)

		return "%s.select(%s)" % (self.src.to_spark(exec_context), ", ".join(generate_items))

from Node import Node


class NestedForeach(Node):
	def __init__(self, src, nested_commands, generate_items):
		self.src = src
		self.nested_commands = nested_commands
		self.generate_items = generate_items
		self.fields = []
		self.type = "NESTED_FOREACH"


	def __str__(self):
		return "FOREACH:%s = for %s, generate:%s" % (self.target, self.src, ", ".join(map(str, self.genItems)))

	def to_spark(self, exec_context):
		generate_items = []

		for generate_item in self.generate_items:
			generate_items.append(generate_item.to_spark(exec_context))

		return "%s.select(%s)" % (self.src.to_spark(exec_context), ", ".join(generate_items))

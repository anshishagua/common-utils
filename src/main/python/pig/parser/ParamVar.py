from Node import Node


class ParamVar(Node):
	def __init__(self, value):
		self.value = value
		self.children = []
		self.type = "PARAM_VAR"

	def __str__(self):
		return "PARAM_VAR: '$%s'" % (self.value)

	def to_spark(self, exec_context):
		return self.value
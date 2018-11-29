from Node import Node


class Define(Node):
	def __init__(self, var, expr):
		self.var = var
		self.expr = expr
		self.type = "DEFINE"
		self.children = []

	def __str__(self):
		return "DEFINE: %s = %s" % (self.var, self.expr)

	def to_spark(self, exec_context):
		pass

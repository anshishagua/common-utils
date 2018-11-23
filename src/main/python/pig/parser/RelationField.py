from Node import Node


class SimpleField(Node):
	def __init__(self, name, data_type, relation):
		self.name = name
		self.data_type = data_type
		self.relation = relation
		self.children = []
		self.type = "SIMPLE_FIELD"

class GroupField(Node):
	pass


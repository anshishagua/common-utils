from Node import Node


class SimpleField(Node):
	def __init__(self, name, data_type=None, relation=None):
		self.name = name
		self.data_type = data_type
		self.relation = relation
		self.children = []
		self.type = "SIMPLE_FIELD"


class GroupByField(Node):
	def __init__(self, group_by_fields, relation=None):
		self.name = "group"
		self.relation = relation
		self.group_by_fields = group_by_fields
		self.children = []
		self.type = "GROUP_FIELD"
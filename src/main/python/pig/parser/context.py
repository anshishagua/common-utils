class ExecContext(object):
	def __init__(self):
		self.relation_map = {}
		self.raw = False
		self.schema_root = None
		self.params = {}

	def __str__(self):
		return "relations:%s" % self.relation_map
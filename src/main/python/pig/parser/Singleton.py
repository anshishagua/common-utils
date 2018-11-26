class Singleton(object):
	def __new__(cls, *args, **kwargs):
		if not hasattr(cls, '_instance'):
			cls._instance = super(Singleton, cls).__new__(cls, *args, **kwargs)
			cls._instance.data_map = {}
		return cls._instance
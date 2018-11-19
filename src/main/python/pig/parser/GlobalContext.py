

class GlobalContext(object):
    context = {}

    @staticmethod
    def add(key, value):
        GlobalContext.context[key] = value

    @staticmethod
    def get(key):
        return GlobalContext.context.get(key, None)

    @staticmethod
    def has_key(key):
        return key in GlobalContext.context


data_map = {}

def set_value(key, value):
    global data_map

    data_map[key] = value
    #if data_map is None:
    #    data_map = {}
    #data_map[key] = value


def get_value(key):
    global data_map

    return data_map[key]
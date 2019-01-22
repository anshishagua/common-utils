def _fix_ip(up, ip, open_rate):
    up = None if up is None else float(up)
    ip = None if ip is None else float(ip)
    open_rate = None if open_rate is None else float(open_rate)
    if up is None or open_rate is None or ip is None:
        pass
    elif ip < up and open_rate > 0:
        ip = up / open_rate
    return 1.0 if ip > 1.0 else ip

print _fix_ip(None, None, None)
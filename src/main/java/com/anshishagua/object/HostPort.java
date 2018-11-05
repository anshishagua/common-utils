package com.anshishagua.object;

import java.io.Serializable;

public class HostPort implements Serializable {
    private final String host;
    private final int port;

    public HostPort(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String toString(String separator) {
        return String.format("%s%s%s", host, separator, String.valueOf(port));
    }

    @Override
    public String toString() {
        return "HostPort{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
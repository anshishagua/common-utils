package com.anshishagua.object;

import java.io.Serializable;

public class Record implements Serializable {
    private long timestamp;
    private String value;

    public Record(long timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getValue() {
        return value;
    }
}
package com.anshishagua.object;

import java.io.Serializable;
import java.util.List;

public class Event implements Serializable {
    public static final Event NO_EVENT = new Event(-1, null);

    private long triggeredTimestamp;
    private List<String> triggeredRecords;

    public Event(long triggeredTimestamp, List<String> triggeredRecords) {
        this.triggeredTimestamp = triggeredTimestamp;
        this.triggeredRecords = triggeredRecords;
    }

    public long getTriggeredTimestamp() {
        return triggeredTimestamp;
    }

    public List<String> getTriggeredRecords() {
        return triggeredRecords;
    }
}
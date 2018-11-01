package com.anshishagua.object;

import java.util.List;

public class Event {
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
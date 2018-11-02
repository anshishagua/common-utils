package com.anshishagua.object;

import org.apache.spark.sql.Row;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StreamState implements Serializable {
    private List<Record> records;

    public StreamState() {
        records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void removeRecode(Record record) {
        this.records.remove(record);
    }
}
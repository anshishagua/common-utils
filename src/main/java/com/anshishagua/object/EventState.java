package com.anshishagua.object;

import org.apache.spark.sql.Row;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EventState implements Serializable {
    private List<Row> rows;

    public EventState(List<Row> rows) {
        this.rows = new ArrayList<>();
        this.rows.addAll(rows);
    }

    public void addRow(Row row) {
        this.rows.add(row);
    }

    public List<Row> getRows() {
        return rows;
    }
}

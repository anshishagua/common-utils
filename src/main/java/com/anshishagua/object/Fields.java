package com.anshishagua.object;

import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fields implements Serializable {
    private List<Field> fields;

    public static Fields newInstance(Field ... fields) {
        return new Fields(fields);
    }

    public Fields(Field ... fields) {
        this.fields = new ArrayList<>(fields.length);

        for (int i = 0; i < fields.length; ++i) {
            fields[i].setIndex(i);
            this.fields.add(fields[i]);
        }
    }

    public List<Field> getFields() {
        return fields;
    }

    public void addField(Field field) {
        field.setIndex(fields.size());
        fields.add(field);
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Field getField(int index) {
        return this.fields.get(index);
    }

    public Field getField(String name) {
        for (Field field : fields) {
            if (field.getName().equals(name)) {
                return field;
            }
        }

        return null;
    }

    public Field getTimestampField() {
        List<Field> list = fields.stream().filter(field -> field.isTimestamp()).collect(Collectors.toList());

        return list.get(0);
    }

    public Field getPrimaryKeyField() {
        List<Field> list = fields.stream().filter(field -> field.isPrimaryKey()).collect(Collectors.toList());

        return list.get(0);
    }

    @Override
    public String toString() {
        return "Fields{" +
                "fields=" + fields +
                '}';
    }

    public StructType toStructType() {
        return DataTypes.createStructType(fields.stream().map(field -> field.toStructField()).collect(Collectors.toList()));
    }
}

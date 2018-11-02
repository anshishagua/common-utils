package com.anshishagua.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "Fields{" +
                "fields=" + fields +
                '}';
    }
}

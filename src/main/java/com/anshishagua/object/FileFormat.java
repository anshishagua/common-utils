package com.anshishagua.object;

public enum FileFormat {
    CSV,
    PARQUET;

    public static FileFormat parse(String string) {
        for (FileFormat format : values()) {
            if (format.name().equalsIgnoreCase(string)) {
                return format;
            }
        }

        return null;
    }
}

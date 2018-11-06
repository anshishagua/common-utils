package com.anshishagua.object;

/**
 * TimeUnit.java
 *
 * @author lixiao
 * @date 2018-11-05
 */

public enum TimeUnit {
    MILLI_SECONDS("milliseconds"),
    SECONDS("seconds"),
    MINUTES("minutes"),
    HOURS("hours"),
    DAYS("days");

    private String value;

    TimeUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TimeUnit parseByValue(String value) {
        for (TimeUnit timeUnit : values()) {
            if (timeUnit.value.equals(value)) {
                return timeUnit;
            }
        }

        return null;
    }
}

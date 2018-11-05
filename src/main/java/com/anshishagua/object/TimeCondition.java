package com.anshishagua.object;

/**
 * TimeCondition.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class TimeCondition {
    private int value;
    private TimeUnit timeUnit;

    public TimeCondition(int value, TimeUnit timeUnit) {
        this.value = value;
        this.timeUnit = timeUnit;
    }

    public int getValue() {
        return value;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}

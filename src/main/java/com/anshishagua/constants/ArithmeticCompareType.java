package com.anshishagua.constants;

public enum ArithmeticCompareType {
    LARGER_THAN(">"),
    LARGER_THAN_EQUAL(">="),
    EQUAL("="),
    NOT_EQUAL("!="),
    LOWER_THAN("<"),
    LOWER_THAN_EQUAL("<=");

    private String value;

    ArithmeticCompareType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
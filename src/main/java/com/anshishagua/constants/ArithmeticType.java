package com.anshishagua.constants;

public enum ArithmeticType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MOD("%");

    private String value;

    ArithmeticType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package com.anshishagua.object;

public enum JoinType {
    INNER("inner"),
    OUTER("outer"),
    LEFT_OUTER("left_outer"),
    RIGHT_OUTER("right_outer"),
    LEFT_SEMI("leftsemi");

    private String value;

    JoinType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
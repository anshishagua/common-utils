package com.anshishagua.object.nodes;

/**
 * AritmeticCompare.java
 *
 * @author lixiao
 * @date 2018-11-06
 */

public class AritmeticCompare {
    public enum CompareType {
        LARGER_THAN,
        LARGER_THAN_EQUAL,
        EQUAL,
        NOT_EQUAL,
        LOWER_THAN,
        LOWER_THAN_EQUAL
    };

    private Node left;
    private Node right;
    private CompareType compareType;

}

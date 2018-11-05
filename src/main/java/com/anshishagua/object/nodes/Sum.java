package com.anshishagua.object.nodes;

import com.anshishagua.object.TimeCondition;

import java.sql.Timestamp;

/**
 * Sum.java
 *
 * @author lixiao
 * @date 2018-11-05
 */

public class Sum implements Node {
    private Node expression;
    private TimeCondition timeCondition;
}

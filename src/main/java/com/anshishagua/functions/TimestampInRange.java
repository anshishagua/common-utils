package com.anshishagua.functions;

import org.apache.spark.sql.api.java.UDF3;

/**
 * TimestampInRange.java
 *
 * @author lixiao
 * @date 2018-11-02
 */

public class TimestampInRange implements UDF3<Long, Long, Long, Boolean> {
    @Override
    public Boolean call(Long timestamp1, Long timestamp2, Long milliseconds) {
        return Math.abs(timestamp1 - timestamp2) <= milliseconds;
    }
}

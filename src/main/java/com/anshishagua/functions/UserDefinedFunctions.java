package com.anshishagua.functions;

import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.api.java.UDF3;

import java.sql.Timestamp;

/**
 * UserDefinedFunctions.java
 *
 * @author lixiao
 * @date 2018-11-02
 */

public class UserDefinedFunctions {
    public static final UDF1<String, Timestamp> PARSE_TIMESTAMP_STRING_PARAM = new UDF1<String, Timestamp>() {
        @Override
        public Timestamp call(String string) throws Exception {
            try {
                return Timestamp.valueOf(string);
            } catch (IllegalArgumentException ex) {
                return new Timestamp(Long.parseLong(string));
            }
        }
    };

    public static final UDF1<Long, Timestamp> PARSE_TIMESTAMP_LONG_PARAM = new UDF1<Long, Timestamp>() {
        @Override
        public Timestamp call(Long value) throws Exception {
            return new Timestamp(value);
        }
    };

    public static final UDF3<Timestamp, Timestamp, String, Boolean> TIMESTAMP_WITHIN = new UDF3<Timestamp, Timestamp, String, Boolean>() {
        @Override
        public Boolean call(Timestamp t1, Timestamp t2, String s) {
            String[] fields = s.split(" ");
            int n = Integer.parseInt(fields[0].trim());
            int factor = 1;
            //milliseconds, seconds, minutes, hours, days,
            String unit = fields[1].trim();

            switch (unit) {
                case "seconds":
                    factor = 1000;
                    break;
                case "minutes":
                    factor = 1000 * 60;
                    break;
                case "hours":
                    factor = 1000 * 60 * 60;
                    break;
                case "days":
                    factor = 1000 * 60 * 60 * 24;
                    break;
                default:
                    break;
            }

            n *= factor;

            return Math.abs(t1.getTime() - t2.getTime()) <= n;
        }
    };
}

package com.anshishagua.functions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;

import java.util.Objects;

public class ParseJson implements UDF2<String, String, String> {
    public static final String FUNCTION_NAME = "parse_json";

    public static final ParseJson INSTANCE = new ParseJson();
    public static final DataType RETURN_TYPE = DataTypes.StringType;

    @Override
    public String call(String json, String field) {
        JSONObject jsonObject = JSON.parseObject(json);

        Object object = jsonObject.get(field);

        return Objects.toString(object);
    }
}

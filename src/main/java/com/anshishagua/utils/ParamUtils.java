package com.anshishagua.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamUtils {
    public static final Pattern PARAM_PATTERN = Pattern.compile("\\$\\{[a-zA-Z0-9_]+\\}");

    public static String replace(String string, Map<String, String> params) {
        Objects.requireNonNull(string);
        Objects.requireNonNull(params);

        Matcher matcher = PARAM_PATTERN.matcher(string);

        String result = string;

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            String pattern = string.substring(start, end);
            String key = pattern.substring(2, pattern.length() - 1);

            String value = params.getOrDefault(key, null);

            if (value == null) {
                throw new IllegalArgumentException(String.format("Param %s not in map or is null", key));
            }

            result = result.replace(pattern, value);
        }

        return result;
    }

    public static void main(String [] args) {
        String string = "/tmp/user_info/date=${date}/version=${version}";

        Map<String, String> map = new HashMap<>();
        map.put("date", "2018-09-10");
        map.put("version", "v1.0.0");

        System.out.println(replace(string, map));
    }
}

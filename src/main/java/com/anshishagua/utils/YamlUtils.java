package com.anshishagua.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class YamlUtils {
    public static String getAsString(Object yaml, String path, String defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : Objects.toString(object);
    }

    public static Boolean getAsBoolean(Object yaml, String path, Boolean defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : (object instanceof Boolean) ? (Boolean) object : defaultValue;
    }

    public static Integer getAsInteger(Object yaml, String path, Integer defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : (object instanceof Integer) ? (Integer) object : defaultValue;
    }

    public static Long getAsLong(Object yaml, String path, Long defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : (object instanceof Long) ? (Long) object : defaultValue;
    }

    public static Float getAsFloat(Object yaml, String path, Float defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : (object instanceof Float) ? (Float) object : defaultValue;
    }

    public static Double getAsDouble(Object yaml, String path, Double defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : (object instanceof Double) ? (Double) object : defaultValue;
    }

    public static <T> T getAsBean(Object yaml, String path, Class<T> clazz, T defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : JSON.parseObject(JSON.toJSONString(getAsMap(yaml, path, new HashMap<>())), clazz);
    }

    public static Map<String, Object> getAsMap(Object yaml, String path, Map<String, Object> defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : (object instanceof Map) ? (Map<String, Object>) object : defaultValue;
    }

    public static List<Object> getAsList(Object yaml, String path, List<Object> defaultValue) {
        Object object = get(yaml, path, null);

        return object == null ? defaultValue : object instanceof List ? (List<Object>) object : defaultValue;
    }

    public static <T> T get(Object object, String path) {
        return (T) get(object, path, null);
    }

    public static boolean containsKey(Object object, String path) {
        return get(object, path) != null;
    }

    public static <T> T get(Object object, String path, T defaultValue) {
        Objects.requireNonNull(path);
        Objects.requireNonNull(object);

        String [] fields = path.split("\\.");

        T result = null;

        for (int i = 0; i < fields.length; ++i) {
            String field = fields[i];
            int index = 0;
            int start = field.indexOf("[");
            int end = field.indexOf("]");
            boolean hasIndex = false;

            if (start >= 0 && end >= 0 && start < end) {
                try {
                    index = Integer.parseInt(field.substring(start + 1, end));
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException();
                }

                field = field.substring(0, start);

                hasIndex = true;
            }

            if (object == null || !(object instanceof Map)) {
                result = defaultValue;
                break;
            }

            Map<String, Object> map = (Map<String, Object>) object;

            object = map.get(field);

            if (hasIndex) {
                if (object == null || !(object instanceof List)) {
                    result = defaultValue;
                    break;
                }

                List<Object> list = (List<Object>) object;

                if (index >= list.size() || -index > list.size()) {
                    result = defaultValue;
                    break;
                }

                object = index >= 0 ? list.get(index) : list.get(list.size() + index);
            }

            if (i == fields.length - 1) {
                result = (T) object;
            }
        }

        return result;
    }
}
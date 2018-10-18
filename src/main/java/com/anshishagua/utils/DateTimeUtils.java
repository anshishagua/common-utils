package com.anshishagua.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DateTimeUtils {
    public static List<LocalDate> generate(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);

        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(String.format("start %s > end %s", start.toString(), end.toString()));
        }

        List<LocalDate> list = new ArrayList<>();

        for (LocalDate date = start; date.compareTo(end) <= 0; date = date.plusDays(1)) {
            list.add(date);
        }

        return list;
    }
}

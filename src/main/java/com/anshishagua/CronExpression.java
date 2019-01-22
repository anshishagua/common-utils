package com.anshishagua;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public class CronExpression {
    class ParseException extends Exception {
        public ParseException(String message) {
            super(message);
        }
    }

    private String expression;
    private SortedSet<Integer> seconds;
    private SortedSet<Integer> minutes;
    private SortedSet<Integer> hours;
    private SortedSet<Integer> dates;
    private SortedSet<Integer> months;
    private SortedSet<Integer> years;
    private SortedSet<Integer> weeks;

    public CronExpression(String expression) {
        Objects.requireNonNull(expression);

        String expr = expression.toUpperCase();
    }

    private void parse() throws ParseException {

    }

    public LocalDateTime getNextRunTime(LocalDateTime from) {
        return null;
    }
}

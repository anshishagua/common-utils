package com.anshishagua;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CronExpression {
    class ParseException extends Exception {
        public ParseException(String message) {
            super(message);
        }
    }

    private String expression;
    private SortedSet<Integer> seconds = new TreeSet<>();
    private SortedSet<Integer> minutes = new TreeSet<>();
    private SortedSet<Integer> hours = new TreeSet<>();
    private SortedSet<Integer> dates = new TreeSet<>();
    private SortedSet<Integer> months = new TreeSet<>();
    private SortedSet<Integer> years = new TreeSet<>();
    private SortedSet<Integer> weeks = new TreeSet<>();

    public CronExpression(String expression) {
        Objects.requireNonNull(expression);

        this.expression = expression;
    }

    private void checkRange(int value, int minValue, int maxValue) throws ParseException {
        if (value < minValue) {
            throw new ParseException("value < min");
        }

        if (value > maxValue) {
            throw new ParseException("value > max");
        }
    }

    private SortedSet<Integer> parseEnumValues(String [] values, int minValue, int maxValue) throws ParseException {
        SortedSet<Integer> result = new TreeSet<>();

        for (String value : values) {
            //0-0
            if (value.contains("-")) {
                int start = Integer.parseInt(value.split("-")[0]);
                int end = Integer.parseInt(value.split("-")[1]);

                checkRange(start, minValue, maxValue);
                checkRange(end, minValue, maxValue);

                IntStream.range(start, end + 1).forEach(it -> result.add(it));
            } else if (value.contains("/")) {
                int start = Integer.parseInt(value.split("/")[0]);
                int step = Integer.parseInt(value.split("/")[1]);

                checkRange(start, minValue, maxValue);
                checkRange(step, 1, Integer.MAX_VALUE);

                for (int i = start; i <= maxValue; i += step) {
                    result.add(i);
                }
            } else {
                result.add(Integer.parseInt(value));
            }
        }

        return result;
    }

    private SortedSet<Integer> parse(String expression, int minValue, int maxValue) throws ParseException {
        SortedSet<Integer> result = new TreeSet<>();

        if (expression.equals("*")) {
            int [] values = IntStream.range(minValue, maxValue + 1).toArray();

            for (int value : values) {
                result.add(value);
            }
        } else {
            if (expression.contains("*")) {
                throw new ParseException("*");
            }

            String [] enumValues = null;

            if (expression.contains(",")) {
                enumValues = expression.split(",");
            } else {
                enumValues = new String[] {expression};
            }

            result = parseEnumValues(enumValues, minValue, maxValue);
        }

        return result;
    }

    private boolean isLeapYear(int year) {
        return false;
    }

    //private Set<Integer> parse

    //Seconds Minutes Hours DayofMonth Month DayofWeek Year
    //Seconds Minutes Hours DayofMonth Month DayofWeek
    private void parse() throws ParseException {
        String expression = this.expression.toUpperCase().trim();

        String [] fields = expression.split(" +");

        if (fields.length != 6 && fields.length != 7) {
            throw new ParseException("");
        }

        seconds.addAll(parse(fields[0].trim(), 0, 59));

        System.out.println(seconds);

        minutes.addAll(parse(fields[1].trim(), 0, 59));

        System.out.println(minutes);

        hours.addAll(parse(fields[2].trim(), 0, 23));

        System.out.println(hours);

        String dayOfMonthExpr = fields[3].trim();

        if (dayOfMonthExpr.contains("? L W C")) {

        } else {
            dates.addAll(parse(dayOfMonthExpr, 0, 31));
        }

        for (String string : fields) {
            System.out.println(string);
        }
    }

    public LocalDateTime getNextRunTime(LocalDateTime from) {
        return null;
    }

    public static void main(String [] args) throws Exception {
        String string = "3/3,5/5,19,1,2,5-9 0,1-22 12,5/5 * * ?";

        CronExpression expression = new CronExpression(string);

        CronSequenceGenerator generator = new CronSequenceGenerator("3/3,5/5,1,2 * * * * ?");
        Date date = new Date();

        for (int i = 0; i < 5; ++i) {
            date = generator.next(date);

            System.out.println(date);
        }
        expression.parse();
    }
}

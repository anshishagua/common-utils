package com.anshishagua;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CronExpression {
    public static final int FIELD_SIZE_WITHOUT_YEAR = 6;
    public static final int FIELD_SIZE_WITH_YEAR = 7;

    public static final int MIN_SECOND = 0;
    public static final int MAX_SECOND = 59;

    public static final int MIN_MINUTE = 0;
    public static final int MAX_MINUTE = 59;

    public static final int MIN_HOUR = 0;
    public static final int MAX_HOUR = 23;

    public static final int MIN_MONTH_DAY = 1;
    public static final int MAX_MONTH_DAY = 31;

    public static final int MIN_MONTH = 1;
    public static final int MAX_MONTH = 12;

    public static final int MIN_YEAR = 1000;
    public static final int MAX_YEAR = 9999;

    public static final int MIN_WEEKDAY = 1;
    public static final int MAX_WEEKDAY = 7;

    public static final Map<String, Integer> MONTH_MAP = buildMonthMap();
    public static final Set<String> MONTH_NAMES = MONTH_MAP.keySet();

    public static final Map<String, Integer> WEEK_MAP = buildWeekMap();
    public static final Set<String> WEEK_NAMES = WEEK_MAP.keySet();

    private static Map<String, Integer> buildMonthMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("JAN", 1);
        map.put("FEB", 2);
        map.put("MAR", 3);
        map.put("APR", 4);
        map.put("MAY", 5);
        map.put("JUN", 6);
        map.put("JUL", 7);
        map.put("AUG", 8);
        map.put("SEP", 9);
        map.put("OCT", 10);
        map.put("NOV", 11);
        map.put("DEC", 12);

        return map;
    }

    private static Map<String, Integer> buildWeekMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("MON", 1);
        map.put("TUE", 2);
        map.put("WED", 3);
        map.put("THU", 4);
        map.put("FRI", 5);
        map.put("SAT", 6);
        map.put("SUN", 7);

        return map;
    }

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

    private String replaceValueInMap(String expression, Map<String, Integer> map) throws ParseException {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            expression = expression.replace(entry.getKey(), String.valueOf(entry.getValue()));
        }

        for (int i = 0; i < expression.length(); ++i) {
            if (Character.isLetter(expression.charAt(i))) {
                StringBuilder builder = new StringBuilder();

                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    builder.append(expression.charAt(i));

                    ++i;
                }

                throw new ParseException(builder.toString());
            }
        }

        return expression;
    }

    private String replaceMonthExpr(String expression) throws ParseException {
        return replaceValueInMap(expression, MONTH_MAP);
    }

    private String replaceWeekExpr(String expression) throws ParseException {
        return replaceValueInMap(expression, WEEK_MAP);
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
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int getCurrentYear() {
        return LocalDateTime.now().getYear();
    }

    //private Set<Integer> parse

    //Seconds Minutes Hours DayofMonth Month DayofWeek Year
    //Seconds Minutes Hours DayofMonth Month DayofWeek
    private void parse() throws ParseException {
        String expression = this.expression.toUpperCase().trim();

        String [] fields = expression.split(" +");

        if (fields.length != FIELD_SIZE_WITHOUT_YEAR && fields.length != FIELD_SIZE_WITH_YEAR) {
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

        String monthExpr = fields[4].trim();

        monthExpr = replaceMonthExpr(monthExpr);

        months.addAll(parse(monthExpr, MIN_MONTH, MAX_MONTH));

        System.out.println("month:" + months);

        String weekExpr = fields[5].trim();

        weekExpr = replaceWeekExpr(weekExpr);

        weeks.addAll(parse(weekExpr, MIN_WEEKDAY, MAX_WEEKDAY));

        System.out.println("week:" + weeks);

        if (fields.length == FIELD_SIZE_WITH_YEAR) {
            String yearExpr = fields[6];

            years = parse(yearExpr, getCurrentYear(), MAX_YEAR);
        } else {
            int [] values = IntStream.range(getCurrentYear(), MAX_YEAR + 1).toArray();

            for (int year : values) {
                years.add(year);
            }
        }

        System.out.println("year:" + years);

        for (String string : fields) {
            System.out.println(string);
        }
    }

    public LocalDateTime getNextRunTime(LocalDateTime from) {
        int year = from.getYear();
        int month = from.getMonthValue();
        int day = from.getDayOfWeek().getValue();
        int hour = from.getHour();
        int minute = from.getMinute();
        int second = from.getSecond();



        return null;
    }

    public static void main(String [] args) throws Exception {
        String string = "3/3,5/5,19,1,2,5-9 0,1-22 12,5/5 * JAN-APR SUN,MON";

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

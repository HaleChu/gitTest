package pers.god.demo.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class DateTimeUtil {
    private static final Pattern PATTERN_DAY = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private static final Pattern PATTERN_MONTH = Pattern.compile("^\\d{4}-\\d{2}$");
    private static final Pattern PATTERN_YEAR = Pattern.compile("^\\d{4}$");

    public DateTimeUtil() {
    }

    public static String display(Long millisecond) {
        if (millisecond != null && millisecond > 0L) {
            if (millisecond < 1000L) {
                return millisecond + "毫秒";
            } else if (millisecond < 60000L) {
                return (double) millisecond / (double) 1000.0F + "秒";
            } else if (millisecond < 3600000L) {
                long second = millisecond % 60000L / 1000L;
                return millisecond / 60000L + "分" + (second > 0L ? second + "秒" : "");
            } else if (millisecond < 86400000L) {
                long minute = millisecond % 3600000L / 60000L;
                return millisecond / 3600000L + "小时" + (minute > 0L ? minute + "分钟" : "");
            } else {
                long hour = millisecond % 86400000L / 3600000L;
                return millisecond / 86400000L + "天" + (hour > 0L ? hour + "小时" : "");
            }
        } else {
            return "0";
        }
    }

    public static boolean isDateStr(String dateStr) {
        dateStr = dateStr.replaceAll("[\\.年月/]", "-").replaceAll("日", "");
        return PATTERN_DAY.matcher(dateStr).matches() || PATTERN_MONTH.matcher(dateStr).matches() || PATTERN_YEAR.matcher(dateStr).matches() || Convert.toDate(dateStr) != null;
    }

    public static String formatDateStr(String dateStr) {
        if (StrUtil.isEmpty(dateStr)) {
            return "";
        } else {
            dateStr = dateStr.replaceAll("[\\.年月/]", "-").replaceAll("[日\\s]", "");
            if (PATTERN_DAY.matcher(dateStr).matches()) {
                return dateStr;
            } else if (PATTERN_MONTH.matcher(dateStr).matches()) {
                return String.format("%s-01", dateStr);
            } else if (PATTERN_YEAR.matcher(dateStr).matches()) {
                return String.format("%s-01-01", dateStr);
            } else {
                Date date = Convert.toDate(dateStr, (Date) null);
                if (date == null) {
                    return dateStr;
                } else {
                    boolean hasTime = dateStr.trim().contains(" ");
                    return DateUtil.format(date, hasTime ? DatePattern.NORM_DATETIME_FORMAT : DatePattern.NORM_DATE_FORMAT);
                }
            }
        }
    }

    public static Date parseDate(Object o) {
        return parseDate(o, (Date) null);
    }

    public static Date parseDate(Object o, Date defaultValue) {
        if (o == null) {
            return null;
        } else if (o instanceof Date) {
            return (Date) o;
        } else {
            return o instanceof CharSequence ? Convert.toDate(formatDateStr((String) o)) : Convert.toDate(o);
        }
    }

    public static List<LocalDate> getWeekendsBetween(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> weekends = new ArrayList<>();
        // 从开始日期开始遍历，直到结束日期
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            // 判断当前日期是否是周六或周日
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekends.add(date);
            }
        }
        return weekends;
    }
}

package com.completeTimeFlow.security.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import static com.completeTimeFlow.security.util.Utils.isNotNull;

public class TimeUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String formatDate(Date date, String format) {
        if (isNotNull(date, format)) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(date);
        }
        return null;
    }

    public static Date getConvertedDate(Date date) {
        if (date == null) {
            return null;
        }

        LocalDateTime ldt = LocalDateTime.parse(Objects.requireNonNull(formatDate(date, DATE_FORMAT)), DateTimeFormatter.ofPattern(DATE_FORMAT));
        GregorianCalendar gc = new GregorianCalendar(ldt.getYear(), ldt.getMonthValue() - 1, ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute(), ldt.getSecond());
        return gc.getTime();
    }

}

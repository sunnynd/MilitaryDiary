package com.android.gotoday.common;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String getStringDateFormat (Calendar calendar) {
        return String.format("%04d-%02d-%02d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static String getStringDateFormat (int year, int month, int day) {
        return String.format("%04d-%02d-%02d", year, month + 1, day);
    }

    public static String getCurrentDate () {
        Calendar calendar = Calendar.getInstance();
        return getStringDateFormat(calendar);
    }

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}

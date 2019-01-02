package com.android.gotoday.common;

import java.util.Calendar;

public class DateUtil {

    public static String getStringDateFormat (Calendar calendar) {
        return String.format("%04d-%02d-%02d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static String getCurrentDate () {
        Calendar calendar = Calendar.getInstance();
        return getStringDateFormat(calendar);
    }
}

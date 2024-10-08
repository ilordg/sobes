package com.sobes.meetup.other;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Класс используется для быстрого получения точного текущего времени по московскому времени.
 */
public class TimeRightNow {
    private final int year;
    private final int month;
    private final int dayOfTheYear;
    private final int dayOfTheMonth;
    private final int dayOfTheWeek;
    private final int hour;
    private final int minute;
    private final int second;
    private final int milliSecond;
    public TimeRightNow() {
        this.year = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.YEAR);
        this.month = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.MONTH);
        this.dayOfTheYear = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.DAY_OF_YEAR);
        this.dayOfTheMonth = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.DAY_OF_MONTH);
        this.dayOfTheWeek = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.DAY_OF_WEEK);
        this.hour = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.HOUR);
        this.minute = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.MINUTE);
        this.second = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.SECOND);
        this.milliSecond = (byte) Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).get(Calendar.MILLISECOND);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfTheYear() {
        return dayOfTheYear;
    }

    public int getDayOfTheMonth() {
        return dayOfTheMonth;
    }

    public int getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getMilliSecond() {
        return milliSecond;
    }
}

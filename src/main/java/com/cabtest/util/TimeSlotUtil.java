package com.cabtest.util;

import com.cabtest.ConfigurationBuilder;
import com.cabtest.bean.TimeSlot;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeSlotUtil {


    public static TimeSlot convertTimeStampToTimeSlots(Timestamp timestamp, boolean ceiling) {

        Calendar midnight = new GregorianCalendar();
        midnight.setTime(new java.util.Date(timestamp.getTime()));
        midnight.set(Calendar.HOUR_OF_DAY, 0);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);
        midnight.set(Calendar.MILLISECOND, 0);

        if (ceiling) {
            return new TimeSlot(Math.ceil((timestamp.getTime() - midnight.getTimeInMillis()) / ConfigurationBuilder
                    .getTimeSlotSizeInMilliSeconds()));
        } else {
            return new TimeSlot(Math.floor((timestamp.getTime() - midnight.getTimeInMillis()) / ConfigurationBuilder
                    .getTimeSlotSizeInMilliSeconds()));
        }
    }

    public static TimeSlot convertDateToTimeSlots(java.util.Date date, boolean ceiling) {
        return convertTimeStampToTimeSlots(new Timestamp(date.getTime()), ceiling);
    }

    public static TimeSlot convertMinutesToTimeSlots(int minutes, boolean ceiling) {
        if (ceiling) {
            return new TimeSlot(Math.ceil(minutes / ConfigurationBuilder.getTimeSlotSizeInMinutes()));
        } else {
            return new TimeSlot(Math.floor(minutes / ConfigurationBuilder.getTimeSlotSizeInMinutes()));
        }
    }

    public static String getDateFromTimestamp(Timestamp timestamp) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(timestamp);
    }

    public static Date getDate(Timestamp timestamp) {
        return new Date(timestamp.getTime());
    }

    public static String getTimeSlotPeriodString(TimeSlot fromTime, TimeSlot toTime) {
        char[] array = new char[getTimeSlotsPerDay()];
        for (int i = 0; i < array.length; i++) {
            if (i >= fromTime.getValue() - 1 && i <= toTime.getValue() - 1) {
                array[i] = '1';
            } else {
                array[i] = '0';
            }
        }
        return new String(array);
    }

    public static BigInteger getTimeSlotPeriodBinaryValue(TimeSlot fromTime, TimeSlot toTime) {
        String bitString = getTimeSlotPeriodString(fromTime, toTime);
        return new BigInteger(bitString, 2);
    }

    public static String getTimeSlotPeriodString(java.util.Date fromTime, java.util.Date toTime) {
        TimeSlot fromTimeSlot = convertDateToTimeSlots(fromTime, false);
        TimeSlot toTimeSlot = convertDateToTimeSlots(toTime, true);

        return getTimeSlotPeriodString(fromTimeSlot, toTimeSlot);

    }

    public static int getTimeSlotsPerDay() {
        return (int) ((24 * 60) / ConfigurationBuilder.getTimeSlotSizeInMinutes());
    }


}

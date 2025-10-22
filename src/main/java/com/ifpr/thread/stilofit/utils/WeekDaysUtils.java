package com.ifpr.thread.stilofit.utils;

import java.util.ArrayList;
import java.util.List;

import com.ifpr.thread.stilofit.models.WeekDays;

public class WeekDaysUtils {
    public static WeekDays mapWeekDaysFromArray(List<String> weekdays) {
        WeekDays weekDays = new  WeekDays();
        if (weekdays != null) {
            for (String day : weekdays) {
                switch (day.toLowerCase()) {
                    case "monday":
                        weekDays.setMonday(true); break;
                    case "tuesday":
                        weekDays.setTuesday(true); break;
                    case "wednesday":
                        weekDays.setWednesday(true); break;
                    case "thursday":
                        weekDays.setThursday(true); break;
                    case "friday":
                        weekDays.setFriday(true); break;
                    case "saturday":
                        weekDays.setSaturday(true); break;
                    case "sunday":
                        weekDays.setSunday(true); break;
                }
            }
        }
        return weekDays;
    }

    public static String[] mapWeekDaysToArray(WeekDays weekDays) {
        if (weekDays == null) return new String[0];
        List<String> days = new ArrayList<>();
        if (weekDays.isMonday()) days.add("monday");
        if (weekDays.isTuesday()) days.add("tuesday");
        if (weekDays.isWednesday()) days.add("wednesday");
        if (weekDays.isThursday()) days.add("thursday");
        if (weekDays.isFriday()) days.add("friday");
        if (weekDays.isSaturday()) days.add("saturday");
        if (weekDays.isSunday()) days.add("sunday");
        return days.toArray(new String[0]);
    }

}

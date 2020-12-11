package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
        System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate birthDate = LocalDate.parse(birthday, formatterDate);
        Year askedYear = Year.parse(year);
        LocalDate askedDate = birthDate.withYear(askedYear.getValue());
            return askedDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}

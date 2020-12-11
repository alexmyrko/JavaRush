package com.javarush.task.task40.task4008;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        if (date.split(" ").length == 2) {
            String stringDate = date.split(" ")[0];
            String stringTime = date.split(" ")[1];
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d.M.yyyy");
            DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("H:mm:ss");
            LocalDate parsedDate = LocalDate.parse(stringDate, formatterDate);
            LocalTime parsedTime = LocalTime.parse(stringTime, formatterTime);
            System.out.println("День: " + parsedDate.getDayOfMonth());
            System.out.println("День недели: " + parsedDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + parsedDate.getDayOfMonth());
            System.out.println("День года: " + parsedDate.getDayOfYear());
            System.out.println("Неделя месяца: " + parsedDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
            System.out.println("Неделя года: " + parsedDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + parsedDate.getMonthValue());
            System.out.println("Год: " + parsedDate.getYear());
            if (parsedTime.get(ChronoField.AMPM_OF_DAY) == 0)
                System.out.println("AM или PM: AM");
            else System.out.println("AM или PM: PM");
            System.out.println("Часы: " + parsedTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + parsedTime.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: " + parsedTime.get(ChronoField.MINUTE_OF_HOUR));
            System.out.println("Секунды: " + parsedTime.get(ChronoField.SECOND_OF_MINUTE));
        }
        else if (date.split("\\.").length == 3) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            System.out.println("День: " + parsedDate.getDayOfMonth());
            System.out.println("День недели: " + parsedDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + parsedDate.getDayOfMonth());
            System.out.println("День года: " + parsedDate.getDayOfYear());
            System.out.println("Неделя месяца: " + parsedDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
            System.out.println("Неделя года: " + parsedDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + parsedDate.getMonthValue());
            System.out.println("Год: " + parsedDate.getYear());
        }
        else if (date.split(":").length == 3){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime parsedTime = LocalTime.parse(date, formatter);
            if (parsedTime.get(ChronoField.AMPM_OF_DAY) == 0)
                System.out.println("AM или PM: AM");
            else System.out.println("AM или PM: PM");
            System.out.println("Часы: " + parsedTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + parsedTime.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: " + parsedTime.get(ChronoField.MINUTE_OF_HOUR));
            System.out.println("Секунды: " + parsedTime.get(ChronoField.SECOND_OF_MINUTE));
        }
    }
}

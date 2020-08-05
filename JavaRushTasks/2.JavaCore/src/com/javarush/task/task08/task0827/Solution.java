package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JAN 2 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        Date parseDate = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH).parse(date);
        Date completeDate = new Date(parseDate.parse(date));
        Date yearBegin = new Date(parseDate.getYear(), 0, 1);
        int diff = (int) (1 + (completeDate.getTime() - yearBegin.getTime())/(24*60*60*1000));
        System.out.println(diff);
        if (diff%2 == 0)
            return true;
        else
            return false;
    }
}

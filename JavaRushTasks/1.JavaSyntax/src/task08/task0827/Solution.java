package com.javarush.task.task08.task0827;

/**
 * Created by alex on 13.05.2017.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Работа с датой
*/

public class Solution {
    public static void main(String[] args)  {
        System.out.println(isDateOdd("FEBRUARY 27 2013"));
    }

    public static boolean isDateOdd(String date)  {
        Date currentDate = new Date(date);
        Date yearStartTime = new Date(date);
        yearStartTime.getYear();
        yearStartTime.setMonth(0);
        yearStartTime.setDate(0);

        int days = (int) ((currentDate.getTime() - yearStartTime.getTime())/1000/60/60/24);
        if (days % 2 != 0)
            return true;
        else
            return false;
    }
}

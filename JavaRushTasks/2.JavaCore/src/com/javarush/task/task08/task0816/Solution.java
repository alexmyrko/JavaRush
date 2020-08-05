package com.javarush.task.task08.task0816;

/**
 * Created by Alex on 05.01.2020.
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Мирко", dateFormat.parse("JAN 8 1981"));
        map.put("Йордан", dateFormat.parse("JUL 1 1995"));
        map.put("Іваненко", dateFormat.parse("FEB 8 1985"));
        map.put("Man", dateFormat.parse("JUN 1 1995"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        for (Date d : map.values()){
            System.out.println(d.getMonth());
        }

    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }
}


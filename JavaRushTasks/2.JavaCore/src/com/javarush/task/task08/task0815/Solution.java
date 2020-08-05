package com.javarush.task.task08.task0815;

/**
 * Created by Alex on 05.01.2020.
 */
import java.util.HashMap;
import java.util.Map;

/*
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Мирко", "Саша");
        map.put("Іваненко", "Андрій");
        map.put("Павлюк", "Василь");
        map.put("Дмитрук", "Андрій");
        map.put("Лисюк", "Ігор");
        map.put("Йордан", "Остап");
        map.put("Волошин", "Ігор");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for (String s: map.values()
             ) {
            if (s.equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        if (map.containsKey(lastName))
            return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Влад"));
        System.out.println(getCountTheSameLastName(map, "Небрех"));
    }
}
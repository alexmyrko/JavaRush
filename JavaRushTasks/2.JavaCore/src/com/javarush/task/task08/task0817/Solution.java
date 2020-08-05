package com.javarush.task.task08.task0817;

/**
 * Created by Alex on 05.01.2020.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        List<String> list = new ArrayList<>();
        int count = 0;
        for (String s : map.values()) {

            for (String s2 : map.values()) {
                if (s2.equals(s))
                    count++;
            }
            if (count > 1)
                list.add(s);
            count = 0;
        }
        for (String s : list
                ) {
            removeItemFromMapByValue(map, s);
        }
        for (Map.Entry<String, String> pair : map.entrySet()
             ) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        System.out.println(value);
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }
}

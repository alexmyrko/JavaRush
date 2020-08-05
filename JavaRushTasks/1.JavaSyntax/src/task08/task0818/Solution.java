package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer> map  = new HashMap<String, Integer>();
        map.put("Мирко", 750);
        map.put("Іваненко", 800);
        map.put("Васьків", 400);
        map.put("Небрех", 700);
        map.put("Нагірний", 500);
        map.put("Йордан", 400);
        map.put("Гриців", 430);
        map.put("Сакало", 550);
        map.put("Средній", 800);
        map.put("Сухий", 480);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map;
        map = createMap();
        removeItemFromMap(map);
        for (Map.Entry<String, Integer> pair : map.entrySet())
              {
                  System.out.println(pair.getKey() + "  " + pair.getValue());
        }
    }
}

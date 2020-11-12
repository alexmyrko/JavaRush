package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Oleksandr");
        map.put("city", "Lviv");
        map.put("bike", "Cube");
        map.put("car", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
//                System.out.println(pair.getKey() + "=" + pair.getValue());
                String s = sb.toString();
                if (!s.equals("")){
                    sb.append(" and ");
                }
                sb.append(pair.getKey() + " = '" + pair.getValue() + "'");
//                System.out.println(sb.toString());
            }
        }
        return sb.toString();
    }
}

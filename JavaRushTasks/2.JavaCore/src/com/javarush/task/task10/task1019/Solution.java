package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/*
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id = 0;
        String name = null;
        Map<String, Integer> map = new HashMap<>();
        while(true) {
                String s = reader.readLine();
                if (s.isEmpty())
                    break;
                id = Integer.parseInt(s);
                name = reader.readLine();
                map.put(name, id);
        }

        for (Map.Entry<String, Integer>  pair : map.entrySet()){
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
//        System.out.println("Id=" + id + " Name=" + name);
    }
}

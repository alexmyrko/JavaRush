package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int data;
        Integer maxValue = 0;
        int key = 0;
        while (inStream.available() > 0){
            data = inStream.read();
            if (!map.containsKey(data))
                map.put(data, 1);
            else  map.put(data, map.get(data) + 1);
        }

        for (Map.Entry entry : map.entrySet()){
            if ((Integer)entry.getValue() > maxValue) {
                maxValue = (Integer)entry.getValue();
            }
        }

//        System.out.println(map);

        for(Map.Entry entry : map.entrySet()){
            if (entry.getValue() == maxValue)
                System.out.print(entry.getKey() + " ");
        }

        inStream.close();
    }
}

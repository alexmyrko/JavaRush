package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Integer minValue = 0;
        int data;

        while(inStream.available() > 0){
            data = inStream.read();
                if (!map.containsKey(data))
                    map.put(data, 1);
                else map.put(data,  map.get(data) + 1);
        }

        boolean firstRead = false;
        for (Map.Entry entry : map.entrySet()){
            if (firstRead == false) {
            minValue = (Integer) entry.getValue();
            firstRead = true;
            }
            if ((Integer )entry.getValue() < minValue)
                minValue = (Integer) entry.getValue();
        }

        for(Map.Entry entry : map.entrySet()){
            if (entry.getValue().equals(minValue))
                System.out.print(entry.getKey() + " ");
        }

        inStream.close();
    }
}

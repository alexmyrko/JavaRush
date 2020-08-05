package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        SortedMap<String, Double> map = new TreeMap<>();
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        String[] data;
        while((line = reader.readLine()) != null){
            data = line.split(" ");
            if (map.containsKey(data[0])){
                map.put(data[0], map.get(data[0]) + Double.parseDouble(data[1]));
            } else {
                map.put(data[0], Double.parseDouble(data[1]));
            }
        }
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        reader.close();
        fileReader.close();
    }
}

package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        SortedMap<String, Double> map = new TreeMap<>();
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        String[] data;
        Double max = 0.0;
        String maxPerson = null;
        ArrayList <String> list = new ArrayList<>();
        while((line = reader.readLine()) != null){
            data = line.split(" ");
            if (map.containsKey(data[0])){
                map.put(data[0], map.get(data[0]) + Double.parseDouble(data[1]));
            } else {
                map.put(data[0], Double.parseDouble(data[1]));
            }
        }
        for (Map.Entry entry : map.entrySet()){
            if ((Double)entry.getValue() > max) {
                max = (Double) entry.getValue();
            }
        }
        for (Map.Entry entry : map.entrySet()){
            if ((double)entry.getValue() == max)
                list.add(String.valueOf(entry.getKey()));
        }
        Collections.sort(list);
        for (String l : list
             ) {
            System.out.println(l);
        }
        reader.close();
        fileReader.close();
    }
}

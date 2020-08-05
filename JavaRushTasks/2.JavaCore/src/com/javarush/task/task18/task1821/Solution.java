package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inStream = new FileInputStream(args[0]);
        int data;
        SortedMap<Character, Integer> map = new TreeMap<Character, Integer>();

        while(inStream.available() > 0){
            data = inStream.read();
            if ((0 < data) && (data < 127)){
                if (map.containsKey((char)data))
                    map.put((char)data, map.get((char)data) + 1);
                else map.put((char)data, 1);
            }
        }

        ArrayList<Character> list = new ArrayList<>();

        for(Map.Entry entry : map.entrySet()){
            list.add((Character) entry.getKey());
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i) + " " + map.get(list.get(i)));
        }

        inStream.close();
    }
}

package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        HashSet<Integer> set = new HashSet<>();
        int data;
        while (inStream.available() > 0){
            data = inStream.read();
            if (!set.contains(data))
                set.add(data);
        }

        List<Integer> list =  new ArrayList<>(set);
        Collections.sort(list);

        for (Integer l : list) {
            System.out.print(l + " ");
        }
        
        inStream.close();
    }
}

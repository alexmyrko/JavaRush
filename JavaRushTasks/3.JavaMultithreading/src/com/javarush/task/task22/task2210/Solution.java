package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] arr = (getTokens("level22.lesson13.task01", "."));
        for (String s : arr)
            System.out.println(s);
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList<>();
        while(tokenizer.hasMoreTokens()){
            list.add((String) tokenizer.nextElement());
        }
        String[] array = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
    }
}

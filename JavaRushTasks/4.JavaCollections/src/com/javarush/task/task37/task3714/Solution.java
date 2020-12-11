package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int result = 0;
        int pointer = 0;
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        char[] letters = reversed.toCharArray();
        for (int i = 0; i < letters.length; i++){
            int value = map.get(String.valueOf(letters[i]));
            if (value >= max) {
                result += value;
                max = value;
            } else
                result -= value;
        }
        return  result;

    }
}

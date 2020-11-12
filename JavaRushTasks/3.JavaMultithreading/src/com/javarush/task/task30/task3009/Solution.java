package com.javarush.task.task30.task3009;

/* 
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String s){
        Set<Integer> set = new HashSet<>();
        if (!s.startsWith("0") && s.matches("\\d+")) {
            int n = Integer.parseInt(s);
            for (int i = 2; i <= 36; i++) {
                String number = Integer.toString(n, Integer.valueOf(i));
                if (number.contentEquals(new StringBuilder(number).reverse()))
                    set.add(i);
            }
        }
        return set;
    }
}
package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("s"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null)
            return false;
        s=s.toLowerCase();
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else map.put(s.charAt(i), 1);
        }
        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() % 2 == 1)
                odd++;
        }
        if ((s.length() % 2 == 1 & odd == 1) || odd == 0)
            return true;
        else return false;
    }
}

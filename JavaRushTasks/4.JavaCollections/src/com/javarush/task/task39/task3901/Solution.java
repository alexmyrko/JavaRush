package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        int maxSize = 0;
        Set<Character> set = new HashSet<>();
        Character previous = null;
        for (int i = 0; i < s.length(); i++){
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                count++;
                previous = s.charAt(i);
                if (count > maxSize)
                    maxSize = count;
                System.out.println(maxSize + " " + set);
            } else if (s.charAt(i) == previous) {
                set.clear();
                set.add(previous);
                count = 1;
            }
        }
        return maxSize;
    }
}

package com.javarush.task.task39.task3909;

import java.util.HashMap;
import java.util.Map;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("mama", "dama"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.equals(second))
            return true;
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        if (first.isEmpty() || second.isEmpty()) {
            return true;
        }
        first = first + "1";
        second = second + "1";
        int shift = 0;
        for (int f = 0, s = 0; f < first.length() && s < second.length(); f++, s++) {
            if (first.charAt(f) == second.charAt(s))
                continue;
            else if ((s + 1) < second.length() && first.charAt(f) == second.charAt(s + 1)){
                shift++;
                s++;
            }
            else if ((f + 1) < second.length() && first.charAt(s) == second.charAt(f + 1)) {
                shift++;
                f++;
            }
            else shift++;
        }
        if (shift > 1) return  false;
        else return true;
    }
}

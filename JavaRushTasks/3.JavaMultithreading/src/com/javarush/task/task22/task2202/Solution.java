package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString(null));

    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();
        String[] words = string.split(" ");
        if (words.length < 5) {
            throw new TooShortStringException();
        }
        String result = "";
        for (int i = 0; i < words.length; i++)
            if (i > 0 && i < 5)
                result = result + words[i] + " ";
        return result.trim();
    }

    public static class TooShortStringException extends RuntimeException{

    }
}

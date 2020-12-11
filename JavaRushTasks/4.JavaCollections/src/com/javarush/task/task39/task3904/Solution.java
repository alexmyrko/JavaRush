package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/
public class Solution {
    private static int n = 10;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 3 )
            return n;
        else return numberOfPossibleAscents(n-1) + numberOfPossibleAscents( n -2) + numberOfPossibleAscents( n -3);
    }
}


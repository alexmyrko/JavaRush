package com.javarush.task.task09.task0919;

/**
 * Created by alex on 24.02.2018.
 */
public class Solution {
    public static void main(String[] args) {
        try {
            divisionByZero();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void divisionByZero() throws ArithmeticException{
        System.out.println(5/0);
    }
}

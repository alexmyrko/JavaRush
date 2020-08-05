package com.javarush.task.task14.task1419;

import java.io.EOFException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[3];
            arr[4] = 5;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer n = 5;
            n = null;
            System.out.println(n/5);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream fis = new FileInputStream("a.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int a = 5;
            if (a == 5) throw new IllegalArgumentException("Illegal");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "myText";
            int n = parseInt(s, 8);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            if (System.currentTimeMillis() % 2 == 0)
                throw new EOFException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int arr[] = new int[-1];
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int k = 4;
            if (k < 5) throw new ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int k = 4;
            if (k < 5) throw new IllegalStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}

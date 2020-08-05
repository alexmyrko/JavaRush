package com.javarush.task.task10.task1006;

/**
 * Created by alex on 08.03.2018.
 */
public class Solution {
    public static void main(String[] args) {
        short b = (short) 45;
        char c = (short) 'c';
        short s = (short) 1005.22;
        int i =  150000;
        float f =  4.10f;
        double d =  1.256d;
        double result = (f * b) + (i / c) - (d * s) + 562.78d;
        System.out.println("b: " + b);
        System.out.println("c: " + 1*c);
        System.out.println("s: " + s);
        System.out.println("i: " + i);
        System.out.println("f: " + f);
        System.out.println("d: " + d);
        System.out.println();
        System.out.println("f*b: " + f*b);
        System.out.println("i/c: " + i/c);
        System.out.println("d*s: " + d*s);
        System.out.println("562.78d: " + 562.78d);
        System.out.println("result: " + result);
    }
}

package com.javarush.task.task09;

/**
 * Created by alex on 24.02.2018.
 */
public class Solution0905 {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements.length);
        return stackTraceElements.length;
    }
}

package com.javarush.task.task09.task0902;

/**
 * Created by alex on 14.05.2017.
 */

/*
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }

    public static String method2() {
        method3();
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }

    public static String method3() {
        method4();
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }

    public static String method4() {
        method5();
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }

    public static String method5() {
        StackTraceElement[] StackTraceElements = Thread.currentThread().getStackTrace();
        return StackTraceElements[2].getMethodName();
    }
}

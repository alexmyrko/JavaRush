package com.javarush.task.task09.task0903;

/*
Кто меня вызывал?
1. В классе должно быть 5 методов (метод main не учитывать).
2. Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
3. Каждый метод должен возвращать номер строки кода, из которого вызвали этот метод.
4. Для получения номера строки, используй метод getLineNumber класса StackTraceElement.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(method1());
    }

    public static int method1() {
        System.out.println(method2());
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method2() {
        System.out.println(method3());
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method3() {
        System.out.println(method4());
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method4() {
        System.out.println(method5());
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method5() {
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }
}

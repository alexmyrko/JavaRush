package com.javarush.task.task09.task0905;

/**
 Написать метод, который возвращает результат – глубину его стек-трейса – количество методов в нем (количество элементов в списке).
 Это же число метод должен выводить на экран.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
        System.out.println(deep);
    }

    public static int getStackTraceDeep() {
        return Thread.currentThread().getStackTrace().length;
    }
}

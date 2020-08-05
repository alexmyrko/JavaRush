package com.javarush.task.task12.task1207;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Integer n1 = 5;
        int n2 = 7;
        print(n1);
        print(n2);
    }

    public static void print(int n)
    {
        System.out.println("int " + n);
    }

    public static void print(Integer n)
    {
        System.out.println("Integer " + n);
    }
}
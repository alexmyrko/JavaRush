package com.javarush.task.task12.task1210;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public int max(int n1, int n2)
    {
        if (n1 > n2)
            return n1;
        else
            return n2;
    }

    public long max(long n1, long n2)
    {
        if (n1 > n2)
            return n1;
        else
            return n2;
    }

    public double max(double n1, double n2)
    {
        if (n1 > n2)
            return n1;
        else
            return n2;
    }
}


package com.javarush.task.task12.task1209;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public int min(int n1, int n2)
    {
        if (n1 < n2)
            return n1;
        else
            return n2;
    }

    public long min(long n1, long n2)
    {
        if (n1 < n2)
            return n1;
        else
            return n2;
    }

    public double min(double n1, double n2)
    {
        if (n1 < n2)
            return n1;
        else
            return n2;
    }
}

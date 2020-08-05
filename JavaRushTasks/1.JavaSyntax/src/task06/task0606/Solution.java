package com.javarush.task.task06.task0606;

/*
Чётные и нечётные циферки
*/

import java.io.*;

public class Solution {
    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int c = Integer.parseInt(s);

        while (c > 0) {
            if (c % 2 != 0) odd++;
            else
                even++;
            c = c / 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}

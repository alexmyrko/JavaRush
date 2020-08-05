package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String s = outputStream.toString();
        String res = s.replaceAll(" ", "");
        String[] parts = res.split("\\D");
        int number = 0;
        if (res.charAt(parts[0].length()) == '+')
            number = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
        else if (res.charAt(parts[0].length()) == '-')
            number = Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
        else if (res.charAt(parts[0].length()) == '*')
            number = Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
        System.setOut(consoleStream);
        System.out.println(s + String.valueOf(number));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


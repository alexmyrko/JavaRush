package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        int count = 1;
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream arrayStream = new PrintStream(outputStream);
        System.setOut(arrayStream);
        testString.printSomething();
        String line;
        String s = outputStream.toString();
        BufferedReader reader = new BufferedReader(new StringReader(s));
        System.setOut(consoleStream);
        while((line = reader.readLine()) != null){
            System.out.println(line);
            if (count % 2 == 0)
                System.out.println("JavaRush - курсы Java онлайн");
            count++;
        }
        reader.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

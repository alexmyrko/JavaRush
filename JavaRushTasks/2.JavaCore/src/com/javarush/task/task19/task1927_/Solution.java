package com.javarush.task.task19.task1927_;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();
    static final String CONTEXT = "JavaRush - курсы Java онлайн";

    public static void main(String[] args) throws IOException {
        PrintStream consolePrint = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outStream);
        System.setOut(stream);

        testString.printSomething();
        String s = outStream.toString();
        System.setOut(consolePrint);
        BufferedReader reader = new BufferedReader(new StringReader(s));
        String line = null;
        int count = 0;
        while((line = reader.readLine()) != null){
            count++;
            System.out.println(line);
            if (count == 4){
                System.out.println(CONTEXT);
                count = 0;
            }
        }

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

package com.javarush.task.task19.task1913_;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consolePrint = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outStream);
        System.setOut(stream);
        testString.printSomething();
        String s = outStream.toString();
        System.setOut(consolePrint);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                System.out.print(s.charAt(i));
        }
        System.out.println();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
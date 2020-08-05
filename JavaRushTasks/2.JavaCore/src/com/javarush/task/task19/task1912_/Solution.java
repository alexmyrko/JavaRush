package com.javarush.task.task19.task1912_;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
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
        String s2 = s.replaceAll("te", "??");
        System.setOut(consolePrint);
        System.out.println(s2);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

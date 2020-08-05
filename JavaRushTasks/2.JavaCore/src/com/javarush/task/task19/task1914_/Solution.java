package com.javarush.task.task19.task1914_;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream consolePrint = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outStream);
        System.setOut(stream);
        testString.printSomething();
        FileOutputStream fileOutputStream = new FileOutputStream("D:/result.txt");
        PrintStream stream2 = new PrintStream(fileOutputStream);
        System.setOut(stream2);
        testString.printSomething();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
package com.javarush.task.task16.task1616_;

import java.io.BufferedReader;
import java.io.InputStreamReader;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

/* Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds = 0;

        public void run() {
            try {
                while (true){
                    sleep(1000);
                    seconds++;
                }
                //add your code here - добавьте код тут
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}

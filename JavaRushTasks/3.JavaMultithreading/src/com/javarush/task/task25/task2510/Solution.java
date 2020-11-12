package com.javarush.task.task25.task2510;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Exception)
                    System.out.println("Надо обработать");
                else if (e instanceof Error)
                    System.out.println("Нельзя дальше работать");
                else
                    System.out.println("Поживем - увидим");
            }
        });
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    @Override
    public void run() {
            //InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("D:/file111.txt"));
//            System.out.println("I'm running");
//            System.out.println(4/0);
    }
}

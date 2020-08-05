package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread{
        String line = "";
        public void run(){
            for (int i = 0; i < 3; i++) {
                try {
                    line = line + reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (i < 2) line = line + " ";
            }

        }

        public void printResult(){
            System.out.println(line);
        }
    }
}

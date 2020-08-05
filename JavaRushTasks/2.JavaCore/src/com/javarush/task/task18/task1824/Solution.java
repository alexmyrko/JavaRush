package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static boolean isStopped = false;
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!isStopped) {
            new ReadThread(reader.readLine()).join();
        }
    }

    public static class ReadThread extends Thread{
        String fileName;
        public ReadThread(String fileName) throws InterruptedException {
            super();
            this.fileName = fileName;
            start();
        }

        @Override
        public void run() {
            try {
                FileInputStream inStream = new FileInputStream(fileName);
                inStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                isStopped = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

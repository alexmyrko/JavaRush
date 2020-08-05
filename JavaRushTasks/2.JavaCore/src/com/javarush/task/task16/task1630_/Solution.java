package com.javarush.task.task16.task1630_;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static FileReader fileReader;
    public static BufferedReader reader;

    static{
        firstFileName = "D://text11.txt";
        secondFileName = "D://text12.txt";
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public static interface ReadFileInterface {

        void setFileName(String fullFileName) throws FileNotFoundException;

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String stringLine = "";
        String s;
//        String fileName;
        public ReadFileThread() throws FileNotFoundException {
        }

        @Override
        public void setFileName(String fullFileName) throws FileNotFoundException {
            fileReader = new FileReader(fullFileName);
        }

        @Override
        public String getFileContent() throws IOException {
            return stringLine;
        }

        @Override
        public void run() {
            reader = new BufferedReader(fileReader);
            try {
                while ((s = reader.readLine()) != null) {
                        stringLine = stringLine.concat(s + " ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
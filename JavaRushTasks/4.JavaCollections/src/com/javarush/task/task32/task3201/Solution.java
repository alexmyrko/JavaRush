package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws FileNotFoundException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        int seek = Integer.parseInt(args[1]);
        randomAccessFile.seek(seek);
        if ((randomAccessFile.length() - seek) < args[2].length()){
            randomAccessFile.seek(randomAccessFile.length());
        }
        randomAccessFile.write(args[2].getBytes());
    }
}

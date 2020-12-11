package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Solution {
    public static void main(String... args) throws FileNotFoundException,IOException{
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        int seek = Integer.parseInt(args[1]);
        randomAccessFile.seek(seek);
        byte[] bytes = new byte[args[2].getBytes().length];
        randomAccessFile.read(bytes, 0, bytes.length);
        String text = new String(bytes);
        randomAccessFile.seek(randomAccessFile.length());
        if (text.equals(args[2])){
            randomAccessFile.write("true".getBytes());
        } else{
            randomAccessFile.write("false".getBytes());
        }
    }
}

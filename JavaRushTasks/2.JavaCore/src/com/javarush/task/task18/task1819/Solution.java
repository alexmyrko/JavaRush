package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inStream = new FileInputStream(file1);
        byte[] buffer1 = new byte[inStream.available()];
        inStream.read(buffer1);
        inStream.close();
        inStream = new FileInputStream(file2);
        byte[] buffer2 = new byte[inStream.available()];
        inStream.read(buffer2);
        FileOutputStream outStream = new FileOutputStream(file1);

        outStream.write(buffer2);
        outStream.write(buffer1);

        inStream.close();
        outStream.close();
    }
}

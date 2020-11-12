package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        Charset inSet = Charset.forName("Windows-1251");
        Charset outSet = Charset.forName("UTF-8");
        String s = new String(buffer, inSet);
        buffer = s.getBytes(outSet);
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();
    }
}

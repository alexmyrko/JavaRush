package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream inStream = new FileInputStream(args[1]);
        FileOutputStream outStream = new FileOutputStream(args[2]);
        byte[] buffer = new byte[inStream.available()];
        inStream.read(buffer);
        if (args[0].equals("-e")){
            for (int i = 0; i < buffer.length; i++)
                buffer[i] = (byte) (buffer[i] - 5);
        } else if (args[0].equals("-d")){
            for (int i = 0; i < buffer.length; i++)
                buffer[i] = (byte) (buffer[i] + 5);
        }
        outStream.write(buffer);
        inStream.close();
        outStream.close();
    }

}

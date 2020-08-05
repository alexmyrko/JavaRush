package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outStream = new FileOutputStream(reader.readLine(), true);
        FileInputStream inStream1 = new FileInputStream(reader.readLine());
        FileInputStream inStream2 = new FileInputStream(reader.readLine());

        byte[] buffer = new byte[inStream1.available()];
        inStream1.read(buffer);
        outStream.write(buffer);
        buffer = new byte[inStream2.available()];
        inStream2.read(buffer);
        outStream.write(buffer);
        inStream1.close();
        inStream2.close();
        outStream.close();
    }
}

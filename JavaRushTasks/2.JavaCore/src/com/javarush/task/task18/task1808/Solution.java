package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        FileOutputStream outStream1;
        FileOutputStream outStream2;
        outStream1 = new FileOutputStream(reader.readLine());
        outStream2 = new FileOutputStream(reader.readLine());

        byte[] buffer = new byte[inStream.available()];
        int count  = inStream.read(buffer);
        int firstSide = count / 2 + count % 2;
        outStream1.write(buffer, 0, firstSide);
        outStream2.write(buffer, firstSide, count - firstSide);

        inStream.close();
        outStream1.close();
        outStream2.close();
    }
}

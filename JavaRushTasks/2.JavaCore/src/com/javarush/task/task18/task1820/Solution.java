package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        FileOutputStream outStream = new FileOutputStream(reader.readLine());

        byte[] buffer = new byte[inStream.available()];
        inStream.read(buffer);
        String row = new String(buffer);
        String[] elements = row.split(" ");
        String result = "";
        for (int i = 0; i <elements.length ; i++) {
            result = result.concat(Math.round(Float.parseFloat(elements[i])) + " ");
        }
//        System.out.println(result);
        buffer = new byte[result.length()];
        buffer = result.getBytes();
        outStream.write(buffer);

        inStream.close();
        outStream.close();
    }
}

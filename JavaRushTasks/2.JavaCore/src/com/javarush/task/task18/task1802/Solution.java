package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        int data;
        int min = inStream.read();
        while(inStream.available() > 0){
            data = inStream.read();
            if (data <= min) min = data;
        }

        System.out.println(min);
        inStream.close();
    }
}

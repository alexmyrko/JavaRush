package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        int max = 0;
        int data;
        while(inStream.available()>0){
            data = inStream.read();
            if (data > max) max = data;
        }
        System.out.println(max);
        inStream.close();
    }
}

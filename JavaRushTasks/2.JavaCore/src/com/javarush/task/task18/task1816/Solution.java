package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inStream = new FileInputStream(args[0]);
        int count = 0;
        int data;
        while(inStream.available() > 0){
            data = inStream.read();
            if ((64 < data) && (data < 91)  || (96 < data) && (data < 123))
                count++;
        }
        System.out.println(count);
        inStream.close();
    }
}

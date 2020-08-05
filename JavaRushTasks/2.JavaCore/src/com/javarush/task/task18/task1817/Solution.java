package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inStream = new FileInputStream(args[0]);
        int spaces = 0;
        int symbols = 0;
        int data;
        while(inStream.available() > 0){
            data = inStream.read();
            if ((31 < data) && (data < 127))
                symbols++;
            if (data == 32)
                spaces++;
        }
        float result = (float)spaces/symbols * 100;
        System.out.println(String.format("%.2f", result));
        inStream.close();
    }
}

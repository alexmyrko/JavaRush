package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStram = new FileInputStream(reader.readLine());
        int data;
        int count = 0;

        while (inStram.available() > 0){
            data = inStram.read();
            if (data == 44)
                count ++;
        }

        System.out.println(count);

        inStram.close();
    }
}

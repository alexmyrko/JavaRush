package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        reader = new BufferedReader(fileReader);
        String line;
        char[] array = null;
        char[] array2 = null;
        while((line = reader.readLine()) != null){
            array = line.toCharArray();
            array2 = new char[array.length];
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[array.length-i-1];
            }
            System.out.println(array2);
        }
        reader.close();
        fileReader.close();
    }
}

package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader = new BufferedReader(fileReader);
        int count = 0;
        String line = "";
        String[] elements;

        while ((line = reader.readLine()) != null){
            elements = line.split("\\W");
            for (int i = 0; i < elements.length; i++){
                if (elements[i].equals("world"))
                    count++;
            }
        }
        System.out.println(count);
        reader.close();
        fileReader.close();
    }
}

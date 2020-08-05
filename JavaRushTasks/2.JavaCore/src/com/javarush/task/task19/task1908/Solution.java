package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        BufferedWriter writer = new BufferedWriter(fileWriter);
        reader.close();
        reader = new BufferedReader(fileReader);
        String line = "";
        String[] elements;
        int count = 0;
        while ((line = reader.readLine())!= null){
            elements = line.split("\\s+");
            for (int i = 0; i < elements.length; i++) {
                System.out.println(elements[i]);
                if (elements[i].matches("\\d+"))
                    writer.write(elements[i] + " ");
            }
        }

        reader.close();
        fileReader.close();
        writer.close();
        fileWriter.close();
    }
}

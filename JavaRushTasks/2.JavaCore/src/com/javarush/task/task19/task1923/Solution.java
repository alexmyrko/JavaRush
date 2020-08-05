package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fileReader);
        String[] data;
        String line;

        while ((line = reader.readLine()) != null) {
            data = line.split(" ");
            for (int i = 0; i < data.length; i++) {
                if (data[i].matches("(.)*(\\d)(.)*")) {
//                    System.out.print(data[i] + " ");
                    fileWriter.write(data[i] + " ");
                }
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
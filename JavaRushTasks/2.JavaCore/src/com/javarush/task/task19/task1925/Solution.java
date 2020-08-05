package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fileReader);
        String[] data;
        String line;
        String toWrite = null;
        while((line = reader.readLine()) != null){
            toWrite = "";
            data = line.split(" ");
            for (int i = 0; i < data.length; i++) {
                if (data[i].length() > 6) {
                    toWrite = toWrite + data[i] + ",";

                }
            }
            if (toWrite != "")
                fileWriter.write(toWrite.substring(0,toWrite.length() - 1));
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}

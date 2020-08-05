package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        reader.close();
        reader = new BufferedReader(fileReader);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        while (reader.ready()){
            int data = fileReader.read();
            if (data == '.')
                writer.write('!');
            else
                writer.write(data);
        }
        reader.close();
        fileReader.close();
        writer.close();
        fileWriter.close();
    }
}

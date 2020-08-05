package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        BufferedWriter writer = new BufferedWriter(fileWriter);
        reader.close();
        reader = new BufferedReader(fileReader);
        int data;
        Pattern pattern = Pattern.compile("[\\W&&[^а-яА-ЯёЁ\\s]]");
        Matcher m;
        String s;

        while(reader.ready()){
            data = reader.read();
            s = String.valueOf((char) data);
            m = pattern.matcher(s);
            if (m.matches()){}
            else
                writer.write(s);
        }

        reader.close();
        fileReader.close();
        writer.close();
        fileWriter.close();
    }
}

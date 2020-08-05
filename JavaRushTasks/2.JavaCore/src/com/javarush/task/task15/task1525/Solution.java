package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileReader fileReader = new FileReader(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(fileReader);
            String textLine;
            textLine = reader.readLine();
            while (textLine != null) {
                lines.add(textLine);
                textLine = reader.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Fault");
        }
    }

    public static void main(String[] args) {

        System.out.println(lines);
    }
}

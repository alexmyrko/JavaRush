package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        reader = new BufferedReader(new InputStreamReader(inStream));
        int n = Integer.parseInt(args[0]);
        String line;
        String[] elements;
        while((line = reader.readLine()) != null){
            elements = line.split(" ");
            if (Integer.parseInt(elements[0]) == n)
                System.out.println(line);
        }

        inStream.close();
        reader.close();
    }
}

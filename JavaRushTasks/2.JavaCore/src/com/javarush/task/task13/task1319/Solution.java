package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String destFile = reader.readLine();
        FileWriter fw = new FileWriter(destFile);
        BufferedWriter writer = new BufferedWriter(fw);
        String data;

        while (true){
            data = reader.readLine();
            if (data.equals("exit"))
                break;
            else {
                writer.write(data + "\r" + "\n");
                writer.flush();
            }
        }

        writer.close();
        reader.close();
    }
}

package com.javarush.archive.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String sourceName = reader.readLine();
        InputStream inStream = new FileInputStream(sourceName);

        while (inStream.available() > 0){
            System.out.print((char)inStream.read());
        }
        System.out.println();
        inStream.close();
        reader.close();
    }
}
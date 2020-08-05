package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SortedMap<String, Byte[]> map = new TreeMap<>();
        FileInputStream inStream;
        String fullName;
        String fileName = null;
        String suffix;
        String fileNameParts[];
        byte[] buffer = null;
        Byte[] bufferMap = null;

        while (!(fullName = reader.readLine()).equals("end")){
            inStream = new FileInputStream(fullName);
            fileNameParts = fullName.split(".part");
            fileName = fileNameParts[0];
            suffix = fileNameParts[1];
            System.out.println(suffix);
            System.out.println(fileName);
            buffer = new byte[inStream.available()];
            bufferMap = new Byte[buffer.length];
            inStream.read(buffer);
            for (int i = 0; i <buffer.length ; i++) {
                bufferMap[i] = buffer[i];
            }
            map.put(suffix, bufferMap);
            inStream.close();
        }
        FileOutputStream outStream = new FileOutputStream(fileName, true);
        for(Map.Entry entry : map.entrySet()){
            bufferMap = new Byte[((Byte[])entry.getValue()).length];
            bufferMap = (Byte[]) entry.getValue();
            buffer = new byte[bufferMap.length];
            for (int i = 0; i <buffer.length ; i++) {
                buffer[i] = bufferMap[i];
            }
            outStream.write(buffer);
        }
        outStream.close();
    }
}

package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        FileOutputStream outStream = new FileOutputStream(reader.readLine());
        int [] buffer = new int[inStream.available()];
        int count = 0;
        while(inStream.available() > 0){
            buffer[count] = inStream.read();
            count++;
        }

        for (int i = buffer.length -1; i >= 0; i--){
            if ((i > 0) && buffer[i-1] == 13 && buffer[i] == 10 ){
                outStream.write(13);
                outStream.write(10);
                i--;
            } else {
                outStream.write(buffer[i]);
            }
        }
        inStream.close();
        outStream.close();
    }
}

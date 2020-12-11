package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String s = "";
        StringWriter writer = new StringWriter();
        if (reader == null)
            return s;

        char[] buffer = new char[1024 * 8];
        char[] result = new char[1024 * 8];
        int len;
        while ((len = reader.read(buffer)) > 0){
            for (int i = 0; i < len; i++){
                    result[i] = (char) (buffer[i] + key);
            }
            writer.write(result, 0 , len);
        }

        return writer.toString();
    }
}

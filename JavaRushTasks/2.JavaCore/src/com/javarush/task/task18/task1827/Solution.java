package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inStream = new FileInputStream(fileName);
        FileOutputStream outStream = new FileOutputStream(fileName, true);
        reader = new BufferedReader(new InputStreamReader(inStream));
        int id = 0;
        String stringId = null;
        int max = 0;

        String line;
        if (args.length > 1) {
            while ((line = reader.readLine()) != null) {
                stringId = line.substring(0, 8);
                if (stringId.contains(" "))
                    id = Integer.parseInt(stringId.substring(0, stringId.indexOf(' ')));
                else
                    id = Integer.parseInt(stringId);
                if (id > max)
                    max = id;
            }
            max++;
            String idString = buildString(String.valueOf(max), 8);
            String productName = buildString(args[1], 30);
            String price = buildString(args[2], 8);
            String quantity = buildString(args[3], 4);
            String result = "\r\n" + idString + productName + price + quantity;
            byte[] buffer = result.getBytes();
            outStream.write(buffer);
        }
        inStream.close();
        outStream.close();
    }

    public static String buildString(String parsed, int capacity){
        if (parsed.length() > capacity)
            parsed = parsed.substring(0,capacity);
        char[] spaces = new char[capacity - parsed.length()];
        Arrays.fill(spaces, ' ');
        return parsed.concat(String.valueOf(spaces));
    }
}

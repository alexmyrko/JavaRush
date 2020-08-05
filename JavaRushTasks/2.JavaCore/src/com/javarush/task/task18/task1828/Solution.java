package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inStream = new FileInputStream(fileName);
        FileOutputStream outStream;
        reader = new BufferedReader(new InputStreamReader(inStream));
        int id = 0;
        int targetID = 0;
        String beforeParseId = null;
        String productName = null;
        String price = null;
        String quantity = null;
        ArrayList<String> list = new ArrayList<String>();
        String line;
        if (args.length == 2) {
            targetID = Integer.parseInt(args[1]);
        }
        else if (args.length > 2){
            targetID = Integer.parseInt(args[1]);
            productName = args[2];
            price = args[3];
            quantity = args[4];
        } else {
            inStream.close();
            System.exit(0);
        }

        while ((line = reader.readLine()) != null) {
            beforeParseId = line.substring(0, 8);
            if (line.substring(0, 8).contains(" "))
                id = Integer.parseInt(beforeParseId.substring(0, beforeParseId.indexOf(' ')));
            else
                id = Integer.parseInt(beforeParseId);
            if (id == targetID){
                if (args[0].equals("-d")){}
                else if (args[0].equals("-u")){
                    list.add(modify(id, productName, price, quantity));
                }
            } else list.add(line);
        }
        inStream.close();
        outStream = new FileOutputStream(fileName);
        for (String s : list) {
            byte[] buffer = s.getBytes();
            outStream.write(buffer);
            outStream.write('\r');
            outStream.write('\n');
        }
        outStream.close();
    }

    public static String buildString(String parsed, int capacity){
        if (parsed.length() > capacity)
            parsed = parsed.substring(0,capacity);
        char[] spaces = new char[capacity - parsed.length()];
        Arrays.fill(spaces, ' ');
        return parsed.concat(String.valueOf(spaces));
    }

    public static String modify(int id, String productName, String price, String quantity){
        String idString = buildString(String.valueOf(id), 8);
        String productNameString = buildString(productName, 30);
        String priceString = buildString(price, 8);
        String quantityString = buildString(quantity, 4);
        return idString + productNameString + priceString + quantityString;
    }
}

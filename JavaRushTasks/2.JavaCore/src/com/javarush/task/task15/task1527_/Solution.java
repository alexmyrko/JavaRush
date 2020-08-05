package com.javarush.task.task15.task1527_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 31.01.2020.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String row = null;
        List<String> list = new ArrayList<>();

        if (url.contains("?")){
            row = url.substring(url.indexOf("?")+1);
            String parts[] = row.split("&");
            for (int i = 0; i < parts.length; i++){
                if (parts[i].contains("="))
                    System.out.println(parts[i].substring(0, parts[i].indexOf("=")));
                else
                    System.out.println(parts[i]);
            }
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].contains("obj")) {
                    String value = parts[i].substring(parts[i].indexOf("=") + 1);
                    try {
                        alert(Double.parseDouble(value));
                    } catch (NumberFormatException e) {
                        alert(value);
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }



    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

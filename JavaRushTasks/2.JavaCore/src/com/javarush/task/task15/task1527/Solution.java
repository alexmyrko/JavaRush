package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String cuttedUrl = url.substring(url.indexOf("?")+1);
        String [] wholeParameters;
        wholeParameters = cuttedUrl.split("&");
        String value;

        for (int i = 0; i < wholeParameters.length; i++) {
            if (wholeParameters[i].contains("="))
                System.out.print(wholeParameters[i].substring(0, wholeParameters[i].indexOf("=")));
            else System.out.print(wholeParameters[i]);
            if (i < wholeParameters.length - 1) System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < wholeParameters.length; i++)
            if (wholeParameters[i].contains("obj")){
                value = wholeParameters[i].substring(wholeParameters[i].indexOf("=")+1);
                try{
                    alert(Double.parseDouble(value));
                } catch (Exception e) {
                    alert(value);
                }

            }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

package com.javarush.task.task07.task0712;

/**
 * Created by Alex on 04.01.2020.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        boolean first = false;
        int max = 0;
        int min = 0;
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < 10 ; i++) {
            list.add(reader.readLine());
        }
        min = list.get(0).length();
        for (int i = 0; i < list.size(); i++
             ) {
            if (list.get(i).length() < min) {
                min = list.get(i).length();
                minIndex = i;
            }
            if (list.get(i).length() > max) {
                max = list.get(i).length();
                maxIndex = i;
            }
        }
        System.out.println("min:" + min + "  minIndex:" + minIndex + "  msx:" + max + "  maxIndex:" + maxIndex);
        if (minIndex < maxIndex)
            System.out.println(list.get(minIndex));
        else
            System.out.println(list.get(maxIndex));
    }
}
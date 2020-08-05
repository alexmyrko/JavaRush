package com.javarush.task.task07.task0708;

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
        int max = 0;
        String s;
        for (int i = 0; i < 5 ; i++) {
            list.add(reader.readLine());
        }

        for (String st : list
             ) {
            if (st.length() > max)
                max = st.length();
        }
        for (String st : list
             ) {
            if (st.length() == max)
                System.out.println(st);
        }
    }
}

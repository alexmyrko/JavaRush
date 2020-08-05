package com.javarush.task.task07.task07t1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by alex on 22.02.2018.
 */
public class ArrAllList {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] list = new String[10];
        for (int i = 0; i <list.length ; i++) {
            list[i]  = reader.readLine();
        }

        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list2.add(reader.readLine());
        }

        for (int i = 0; i <list.length; i++) {
            System.out.println(list[list.length - i - 1]);
        }

        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }
}


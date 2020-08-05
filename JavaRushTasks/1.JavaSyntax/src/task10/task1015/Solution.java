package com.javarush.task.task10.task1015;

/**
 * Created by Alex2 on 27.05.2017.
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() throws Exception{
        BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
        String s;
        ArrayList<String> list;
        ArrayList<String>[] array = new ArrayList[2];
        for (int j = 0; j < 2; j++){
            list = new ArrayList<String>();
            for (int k = 0; k < 3; k++){
                s = buffered.readLine();
                list.add(s);
            }
            array[j] = list;
        }
        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}

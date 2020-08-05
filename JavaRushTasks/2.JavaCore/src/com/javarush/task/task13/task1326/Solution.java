package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/
import java.lang.String;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<Integer> list = new ArrayList<>();

        while (true){
            String s = br.readLine();
            if (s == null)
                break;
            else {
                int data = Integer.parseInt(s);
                if (data%2 == 0)
                   list.add(data);
            }
        }

        int[] array = new int[list.size()];

        for (int i = 0; i < array.length; i++){
            array[i] = list.get(i);
        }

        int temp;
        for (int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                if (array[j] < array[i]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        for (int n : array){
            System.out.println(n);
        }

        reader.close();
        br.close();
    }
}

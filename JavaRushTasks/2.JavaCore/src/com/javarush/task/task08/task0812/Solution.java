package com.javarush.task.task08.task0812;

/**
 * Created by Alex on 05.01.2020.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        int count = 1;
        int max = 1;
        int t = 0;

        for (int i = 1; i < list.size(); i++
             ) {
            if (list.get(i-1) == list.get(i))
                count++;
            else
                count = 1;
            if (count > max){
                max = count;
                t = list.get(i);
            }
        }
        System.out.println("Times: " + max + "  number: " + t);
    }
}

package com.javarush.task.task08.task0823;

/**
 * Created by Alex on 19.01.2020.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        char[] ch = string.toCharArray();
        for (int i = 0; i < ch.length; i++){
            if(ch[i] == 32) {
                if (ch[i+1]> 97 && ch[i+1] < 122)
                    ch[i + 1] = (char) (ch[i + 1] - 32);
            }
        }
        string = new String(ch);
        System.out.println(string);
    }
}
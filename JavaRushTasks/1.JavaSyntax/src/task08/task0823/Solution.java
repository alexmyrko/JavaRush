package com.javarush.task.task08.task0823;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by alex on 13.05.2017.
 */

/*
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] text = s.toCharArray();

        boolean toUpper = true;
        Character temp;
        for (int i = 0; i < text.length; i++){
            if (Character.isLetter(text[i]) && toUpper){
                temp = Character.toUpperCase(text[i]);
                text[i] = temp;
                toUpper = false;
            }

            if (!toUpper && text[i] == ' ')
                toUpper = true;

            System.out.print(text[i]);
        }
        System.out.println();
    }
}

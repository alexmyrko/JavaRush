package com.javarush.task.task09.task0923;

/*      1. Программа должна считывать данные с клавиатуры.
        2. Программа должна выводить две строки.
        3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
        4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
        5. Каждая строка должна заканчиваться пробелом.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] all = s.toCharArray();
        for (char c : all)
        {
            if (isVowel(c))
                System.out.print(c + " ");
        }

        System.out.println();

        for (char c : all)
        {
            if (!isVowel(c) && (c != ' '))
                System.out.print(c + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}

package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "D:/task2209.txt";
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = reader.readLine();
        String[] words = line.split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder("");
        if (words.length == 0)
            return new StringBuilder();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length; i++){
            list.add(words[i]);
            list = search((LinkedList<String>) list, words);
            if (list.size() != words.length) {
                i++;
                list.clear();
                continue;
            } else break;
        }

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(" ");
            }
        }
        return sb;
    }

    public static LinkedList<String> search(LinkedList<String> list, String[] words){
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            if (!list.contains(word)){
                if (word.toLowerCase().charAt(word.length() - 1) == list.get(0).toLowerCase().charAt(0)) {
                    list.add(0, word);
                } else if (word.toLowerCase().charAt(0) == list.getLast().toLowerCase().charAt(list.getLast().length() - 1)) {
                    list.add(word);
                }
            }
        }
        if (list.size() != words.length)
            search(list, words);
        return list;
    }
}

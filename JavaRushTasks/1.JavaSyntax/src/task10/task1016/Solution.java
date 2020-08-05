package com.javarush.task.task10.task1016;

/**
 * Created by Alex2 on 27.05.2017.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        ArrayList<String> unique  = new ArrayList<String>();
        for (String s : list){
            if (!unique.contains(s))
                unique.add(s);
        }

        for (String s : unique){
            int count = 0;
            for (String all : list){
                if (all.equals(s)){
                    count++;
                    System.out.println(s + " " + count);
                }
            }
            result.put(s, count);
        }
        return result;
    }

}

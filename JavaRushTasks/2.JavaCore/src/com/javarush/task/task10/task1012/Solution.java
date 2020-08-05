package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character,Integer> map = new HashMap<>();
        for (Character c : alphabet){
            map.put(c, 0);
        }

        for (int i = 0; i < list.size(); i++){
            String l = list.get(i);
            char[] chars = l.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                map.put(chars[j], map.get(chars[j]) + 1);
            }
        }

        for (Character c : alphabet){
            System.out.println(c + " - " + map.get(c));
        }

    }
}

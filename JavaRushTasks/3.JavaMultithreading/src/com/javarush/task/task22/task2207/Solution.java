package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String s;
        String line = "";
        StringBuilder bigLine = new StringBuilder(line);
        while ((s = reader.readLine()) != null)
            {
                bigLine.append(s.trim());
                bigLine.append(" ");
                line = bigLine.toString();
            }
        String[] words = line.split(" ");
//        System.out.println(words.length);
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    StringBuilder s2 = new StringBuilder(words[j]);
                    String reversed = s2.reverse().toString();
                    if (words[i].equals(reversed)) {
                        Pair pair = new Pair();
                        pair.first = words[i];
                        pair.second = words[j];
                        result.add(pair);
//                        i++;
                    }
                }
            }
        Set<Pair> set = new HashSet<>();
        set.addAll(result);

        result.clear();
        result.addAll(set);
        for (Pair pair : result){
            System.out.println(pair.first + " " + pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

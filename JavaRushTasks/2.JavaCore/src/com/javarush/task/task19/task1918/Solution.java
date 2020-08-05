package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        List<Integer> list = new ArrayList<Integer>();
        String tag = args[0];
        char[] buffer = new char[1000];
        fileReader.read(buffer);
        String s = String.valueOf(buffer);
        parse(s, tag);
        fileReader.close();
    }

    public static void parse(String s, String tag) {
        String start = "<" + tag;
        String end = "</" + tag + ">";
        int startLength = start.length();
        int endLength = end.length();
        boolean first = true;
        boolean last = false;
        int count = 0;
        int in = 0;
        int out = 0;
        for (int i = 0; i <= s.length() - endLength; i++) {
            if (s.substring(i, i + startLength).equals(start)) {
                if (first) {
                    in = i;
                    first = false;
                    last = false;
                    count++;
                } else count++;
            }
            if (s.substring(i, i + endLength).equals(end)) {
                if (count == 1) {
                    out = i;
                    count--;
                    first = true;
                    last = true;
                } else count--;
            }
            if (first && last) {
                System.out.println(s.substring(in, out + endLength));
                if (s.substring(in + startLength, out).contains(tag))
                    parse(s.substring(in + startLength, out), tag);
                last = false;
                i = out + endLength-1;
            }
        }
    }
}

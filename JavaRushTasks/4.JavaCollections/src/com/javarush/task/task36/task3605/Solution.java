package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        StringWriter stringWriter = new StringWriter();
        char[] buffer = new char[1024 * 8];
        int len = 0;
        while(reader.ready()) {
            len = reader.read(buffer);
            stringWriter.write(buffer, 0, len);
        }
        char[] symbols = stringWriter.toString().toCharArray();
        Set<Character> set = new TreeSet<>();
        for(Character symbol : symbols){
            if (Character.isLetter(symbol))
                set.add(Character.toLowerCase(symbol));
        }
        int counter = 1;
        for(Character character : set) {
            System.out.print(character);
            counter++;
            if (counter > 5)
                break;
        }
    }
}

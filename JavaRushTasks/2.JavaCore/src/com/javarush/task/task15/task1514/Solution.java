package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.15, "key1");
        labels.put(2.15, "key2");
        labels.put(3.15, "key3");
        labels.put(4.15, "key4");
        labels.put(5.15, "key5");
    }
    public static void main(String[] args) {

        System.out.println(labels);
    }
}

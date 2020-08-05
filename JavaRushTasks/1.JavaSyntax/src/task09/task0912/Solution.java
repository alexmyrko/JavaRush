package com.javarush.task.task09.task0912;

/**
 * Created by alex on 24.02.2018.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
    }
}

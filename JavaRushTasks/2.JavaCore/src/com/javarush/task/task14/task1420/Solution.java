package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            float n1 = Float.parseFloat(reader.readLine());
            float n2 = Float.parseFloat(reader.readLine());
            if ((n1 <= 0) || (n2 <= 0)) throw new Exception();
            int n3 = (int) n1;
            int n4 = (int) n2;
            int max = n3 * n4;
            int div = 1;

        for (int i = 2; i <= max; i++){
            if ((n1 % i) == 0 && (n2 % i) == 0) {div = i;}
        }
        System.out.println(div);
        } catch (Exception e) {
            throw e;
        }
    }
}

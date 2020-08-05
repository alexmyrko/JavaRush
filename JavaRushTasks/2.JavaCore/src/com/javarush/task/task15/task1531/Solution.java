package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigDecimal f = BigDecimal.ONE;
        if (n > 150) return"";
        else if (n < 0 ) return "0";
        else {
            for (int i = 1; i <= n; i++){
                f = f.multiply(BigDecimal.valueOf(i));
            }
            return String.valueOf(f);
        }
    }


}

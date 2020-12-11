package com.javarush.task.task39.task3902;

import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Биты были биты
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");

    }

    public static boolean isWeightEven(long number) {
        int count = 0;
        for(int i = 0; i < 64 ; i++){
            long result = number & 1L;
//            System.out.println(Long.toBinaryString(result) + " " + Long.toBinaryString(number));
            if (result == 1)
                count++;
            number = number >> 1;
        }
        return count%2 == 0;
    }
}

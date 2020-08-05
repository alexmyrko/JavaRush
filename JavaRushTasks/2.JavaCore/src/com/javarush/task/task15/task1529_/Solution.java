package com.javarush.task.task15.task1529_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 31.01.2020.
 */
public class Solution {
    static {

        try {
            reset();
        } catch (IOException e) {
            System.out.println("Fault");
        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals("helicopter"))
            result = new Helicopter();
        else if (s.equals("plane")){
            int passengers = Integer.parseInt(reader.readLine());
            result = new Plane(passengers);
        }
        else result = null;
        System.out.println(result.toString());
        //add your code here - добавьте код тут
    }

    public static void main(String[] args) {

    }
}
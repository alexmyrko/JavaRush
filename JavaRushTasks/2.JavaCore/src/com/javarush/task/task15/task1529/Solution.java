package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String parameter = reader.readLine();
        int passeng;
        if (parameter.equals("plane")) {
            passeng = Integer.parseInt(reader.readLine());
            result = new Plane(passeng);
        }
        else if (parameter.equals("helicopter"))
            result = new Helicopter();
    }
}

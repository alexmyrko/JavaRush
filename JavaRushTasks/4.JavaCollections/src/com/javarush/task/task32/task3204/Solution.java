package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        int counter = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        boolean hasDigit = false;
        boolean hasLowercase = false;
        boolean hasUpperCase = false;
        Random random = new Random();
        while(counter < 8) {
            int number = random.nextInt('z' - '0');
            number += 48;
            if (number >= 48 && number <= 57) {
                hasDigit = true;
                bos.write(number);
                counter++;
            } else if (number >= 65 && number <= 90) {
                hasUpperCase = true;
                bos.write(number);
                counter++;
            } else if (number >= 97 && number <= 122) {
                hasLowercase = true;
                bos.write(number);
                counter++;
            }
//            System.out.println(number + " " + (char)number);
            if (counter == 8 && !(hasDigit && hasLowercase && hasUpperCase)){
                counter = 0;
                bos.reset();
            }
        }
        return bos;
    }
}
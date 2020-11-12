package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null)
            return false;
        if (telNumber.matches("^\\+\\d{12}"))
            return true;
        if (telNumber.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{7}"))
            return true;
        if (telNumber.matches("^\\+\\d{8}\\-\\d{2}\\-\\d{2}"))
            return true;
        if (telNumber.matches("^\\d{6}\\-\\d{4}"))
            return true;
        return false;
    }

    public static void main(String[] args) {
        checkTelNumber("+380501234567");
        checkTelNumber("+38(050)1234567");
        checkTelNumber("+38050123-45-67");
        checkTelNumber("050123-4567");
        checkTelNumber("+38)050(1234567");
        checkTelNumber("+38(050)1-23-45-6-7");
        checkTelNumber("050ххх4567");
        checkTelNumber("050123456");
        checkTelNumber("(0)501234567");

    }
}

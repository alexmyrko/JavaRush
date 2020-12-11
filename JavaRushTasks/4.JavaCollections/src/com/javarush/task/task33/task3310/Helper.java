package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {

    public static String generateRandomString(){
        BigInteger bigInt = new BigInteger(130, new SecureRandom());
        return bigInt.toString(36);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}

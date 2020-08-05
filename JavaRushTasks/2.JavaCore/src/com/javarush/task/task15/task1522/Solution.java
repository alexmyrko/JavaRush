package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet()  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        text = reader.readLine();
        if (text.equals(Planet.EARTH))
            thePlanet = new Earth();
        else if (text.equals(Planet.SUN))
            thePlanet = new Sun();
        else if (text.equals(Planet.MOON))
            thePlanet = new Moon();
        else thePlanet = null;
    }
}
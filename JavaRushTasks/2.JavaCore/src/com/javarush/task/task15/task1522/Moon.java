package com.javarush.task.task15.task1522;

/**
 * Created by Alex on 14.01.2019.
 */
public class Moon implements Planet{
    private static Moon instance;
    Moon(){}

    public static Moon getInstance(){
        if (instance == null) {

            instance = new Moon();
        }
        return instance;
    }
}

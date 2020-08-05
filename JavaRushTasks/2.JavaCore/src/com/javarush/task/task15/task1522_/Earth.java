package com.javarush.task.task15.task1522_;

/**
 * Created by Alex on 31.01.2020.
 */
public class Earth implements Planet{
    private static Earth instance;
    private Earth(){}
    public static Earth getInstance(){
        if (instance == null)
            instance = new Earth();
        return instance;
    }
}

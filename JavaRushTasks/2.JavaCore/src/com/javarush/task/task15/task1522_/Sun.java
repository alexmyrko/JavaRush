package com.javarush.task.task15.task1522_;

/**
 * Created by Alex on 31.01.2020.
 */
public class Sun implements Planet{
    private static Sun instance;
    private Sun(){}

    public static Sun getInstance() {
        if (instance == null)
            instance = new Sun();
        return instance;
    }
}

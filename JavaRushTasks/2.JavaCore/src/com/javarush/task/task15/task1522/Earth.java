package com.javarush.task.task15.task1522;

/**
 * Created by Alex on 14.01.2019.
 */
public class Earth implements Planet {
    private static Earth instance;
    Earth(){    }

    public static Earth getInstance(){
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}

package com.javarush.task.task14.task1421_2;

import com.javarush.task.task20.task2008.*;
import com.javarush.task.task20.task2008.Solution;

/**
 * Created by Alex on 30.01.2020.
 */
public class Singleton{
    private static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}

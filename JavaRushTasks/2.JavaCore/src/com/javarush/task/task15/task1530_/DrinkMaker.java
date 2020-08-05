package com.javarush.task.task15.task1530_;

/**
 * Created by Alex on 31.01.2020.
 */
public abstract class DrinkMaker {
    abstract void getRightCup();
    abstract void putIngridient();
    abstract void pour();
    void makeDrink(){
        getRightCup();
        putIngridient();
        pour();
    }
}

package com.javarush.task.task15.task1530_;

import com.javarush.task.task15.task1530.*;

/**
 * Created by Alex on 31.01.2020.
 */
public class TeaMaker extends DrinkMaker{
    @Override
    void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    void putIngridient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    void pour() {
        System.out.println("Заливаем водой");
    }
}

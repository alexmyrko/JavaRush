package com.javarush.task.task15.task1530;

/**
 * Created by Alex on 20.01.2019.
 */
public class LatteMaker extends DrinkMaker{
    @Override
    void getRightCup() {
        System.out.println("Берем чашку для латте");
    }

    @Override
    void putIngredient() {
        System.out.println("Делаем кофе");
    }

    @Override
    void pour() {
        System.out.println("Заливаем молоком с пенкой");
    }
}

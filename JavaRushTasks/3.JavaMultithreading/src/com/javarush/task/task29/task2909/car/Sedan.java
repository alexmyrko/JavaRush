package com.javarush.task.task29.task2909.car;

/**
 * Created by Alex on 20.04.2020.
 */
public class Sedan extends Car{

    public Sedan(int numberOfPassengers){
        super(SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}

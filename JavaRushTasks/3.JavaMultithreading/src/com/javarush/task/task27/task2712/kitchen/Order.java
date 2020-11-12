package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes == null)
            return "";
        else
            return "Your order: " + dishes +" of " + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min";
    }

    public int getTotalCookingTime(){
        int result = 0;
        for(Dish dish : dishes){
            result += dish.getDuration();
        }
        return result;
    }

    public boolean isEmpty(){
        return dishes.size() == 0 ? true : false;
    }

    public List<Dish> getDishes(){
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}

package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.text.ParseException;

public class Restaurant {
    public static void main(String[] args) throws IOException, ParseException {
        Tablet tablet1 = new Tablet(1);
        Tablet tablet2 = new Tablet(2);
//        Tablet tablet3 = new Tablet(3);
//        Tablet tablet4 = new Tablet(4);
//        tablet1.createOrder();
//        tablet3.createOrder();
//        tablet4.createOrder();
        tablet1.toString();

        Cook cook = new Cook("Кухар");
        Waiter waiter = new Waiter();
        DirectorTablet directorTablet = new DirectorTablet();
        cook.addObserver(waiter);
        tablet1.addObserver(cook);
        tablet1.createOrder();
        tablet1.addObserver(cook);
        tablet2.createOrder();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}

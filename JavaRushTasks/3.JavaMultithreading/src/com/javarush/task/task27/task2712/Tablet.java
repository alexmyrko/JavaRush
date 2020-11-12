package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private Order order = null;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number){
        this.number = number;
    }

    public Order createOrder(){
        try {
            order = new Order(this);

            if (order.isEmpty()) {
                return null;
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            setChanged();
        if (!order.isEmpty()) {
            notifyObservers(order);
            try {
                advertisementManager.processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
        return order;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

}

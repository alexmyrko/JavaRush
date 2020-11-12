package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer{
    String name;
    StatisticManager statisticManager = StatisticManager.getInstance();
    public Cook(String name){
        this.name = name;
        System.out.println(toString());
    }

    @Override
    public void update(Observable observable, Object arg) {
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString());
        statisticManager.register(this);
        statisticManager.register(new CookedOrderEventDataRow(order.getTablet().toString(), this.name, order.getTotalCookingTime(), order.getDishes()));
        setChanged();
        notifyObservers(order);
    }

    @Override
    public String toString() {
        return name;
    }
}

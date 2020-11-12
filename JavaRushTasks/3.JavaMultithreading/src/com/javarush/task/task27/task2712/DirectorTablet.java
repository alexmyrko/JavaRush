package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    StatisticManager statisticManager = StatisticManager.getInstance();
    public static void main(String[] args) {

    }

    public void printAdvertisementProfit() throws ParseException {
        Map<Date, Long> videoProfit = statisticManager.processProfit();
        Map<Date, Long> sortedProfitMap = new TreeMap<>(Collections.reverseOrder());
        double total = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        sortedProfitMap.putAll(videoProfit);
        for (Map.Entry<Date, Long> pair : sortedProfitMap.entrySet()){
            double profit = pair.getValue() / 100.0;
            if (profit > 0)
                ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f",sdf.format(pair.getKey()), profit));
            total += profit;
        }
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));
    }
    public void printCookWorkloading() throws ParseException {
        Map<Date, Map<String, Integer>> cooksWorkloading = statisticManager.processCookWorkload();
        Map<Date, Map<String, Integer>> cooksSorted = new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        cooksSorted.putAll(cooksWorkloading);
        for(Map.Entry<Date, Map<String, Integer>> pair1 : cooksSorted.entrySet()){
            ConsoleHelper.writeMessage(sdf.format(pair1.getKey()));
            for(Map.Entry<String, Integer> pair2 : pair1.getValue().entrySet()){
                ConsoleHelper.writeMessage(pair2.getKey() + " - " + (int) Math.round(pair2.getValue()/60.0) + " min");
            }
        }
    }
    public void printActiveVideoSet(){}
    public void printArchivedVideoSet(){}
}

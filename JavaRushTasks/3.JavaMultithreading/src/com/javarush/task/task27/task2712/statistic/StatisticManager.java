package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager(){
    }

    public static StatisticManager getInstance(){
        if (instance == null)
            instance = new StatisticManager();
        return instance;
    }

    public void register(EventDataRow eventDataRow){
        statisticStorage.put(eventDataRow);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    public Map<Date, Long> processProfit() throws ParseException {
        Map<Date,Long> videosProfitMap = new HashMap<>();
        Map<String,Long> profitMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for(EventDataRow dataRow : statisticStorage.getData(EventType.SELECTED_VIDEOS)){
            VideoSelectedEventDataRow eventDataRow = (VideoSelectedEventDataRow) dataRow;
            String parsedDate = sdf.format(eventDataRow.getDate());  // 14-Jul-2013
            if(!profitMap.containsKey(parsedDate))
                profitMap.put(parsedDate, eventDataRow.getAmount());
            else
                profitMap.put(parsedDate, profitMap.get(parsedDate) + eventDataRow.getAmount());
        }
        for(String element : profitMap.keySet()){
            Date date = sdf.parse(element);
            videosProfitMap.put(date, profitMap.get(element));
        }
        return videosProfitMap;
    }

    public Map<Date, Map<String, Integer>> processCookWorkload() throws ParseException {
        Map<String, Map<String, Integer>> workloadList = new HashMap<>();
        Map<Date, Map<String, Integer>> cookWorkloadList = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for(EventDataRow dataRow : statisticStorage.getData(EventType.COOKED_ORDER)){
            CookedOrderEventDataRow eventDataRow = (CookedOrderEventDataRow) dataRow;
            Map<String, Integer> cooksPerDay = new HashMap<>();
            String parsedDate = sdf.format(eventDataRow.getDate());  // 14-Jul-2013

            if(!workloadList.containsKey(parsedDate)) {
                cooksPerDay.put(eventDataRow.getCookName(), eventDataRow.getCookingTimeSeconds());
                workloadList.put(parsedDate, cooksPerDay);
            }
            else{
                String cookName = eventDataRow.getCookName();
                cooksPerDay = workloadList.get(parsedDate);

                if (cooksPerDay.containsKey(cookName))
                    cooksPerDay.put(cookName, cooksPerDay.get(cookName) + eventDataRow.getCookingTimeSeconds());
                else
                    cooksPerDay.put(cookName, eventDataRow.getCookingTimeSeconds());

                workloadList.put(parsedDate, cooksPerDay);
                }
            }

        for(String key : workloadList.keySet()){
            cookWorkloadList.put(sdf.parse(key), workloadList.get(key));
        }
        return cookWorkloadList;
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage(){
            for (EventType eventType : EventType.values())
                storage.put(eventType, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }

        public List<EventDataRow>getData(EventType eventType){
            return storage.get(eventType);
        }

    }

}

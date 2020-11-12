package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private List<Advertisement> initialSet;
    List<Advertisement> bestSet = new ArrayList<>();
    int timeSeconds;
    long bestAmount;
    StatisticManager statisticManager = StatisticManager.getInstance();

    public AdvertisementManager(int timeSeconds){
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) {
            statisticManager.register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }
        initialSet = createInitialList(storage.list());
        checkAllSets(initialSet);
        if (bestSet.isEmpty())
            throw new NoVideoAvailableException();
        AmountComparator amountComparator = new AmountComparator();
        OneSecondCostComparator oneSecondCostComparator = new OneSecondCostComparator();
        Collections.sort(bestSet, oneSecondCostComparator);
        Collections.sort(bestSet, amountComparator);
        statisticManager.register(new VideoSelectedEventDataRow(bestSet, getCost(bestSet), getDuration(bestSet)));

        for(Advertisement advertisement : bestSet) {
            System.out.println(advertisement);
        }

        for(Advertisement advertisement : storage.list()) {
            if (bestSet.contains(advertisement))
                advertisement.revalidate();
        }
//        printSet(initialSet);
    }

    public List<Advertisement> createInitialList(List<Advertisement> advertisementsFromStorage){
        List<Advertisement> initialList = new ArrayList<>();
        for(Advertisement advertisement : advertisementsFromStorage) {
            if (advertisement.getHits() > 0)
                initialList.add(advertisement);
        }
        return initialList;
    }

    public int getDuration(List<Advertisement> list){
        int duration = 0;
        for (Advertisement element : list){
            duration += element.getDuration();
        }
        return duration;
    }

    public long getCost(List<Advertisement> list){
        long cost = 0;
        for  (Advertisement element : list){
            cost += element.getAmountPerOneDisplaying();
        }
        return cost;
    }


    public void checkSet(List<Advertisement> list){
        if (bestSet == null){
            if(getDuration(list) <= timeSeconds){
                bestSet = list;
                bestAmount = getCost(list);
            }
        } else {
            if (getDuration(list) <= timeSeconds && getCost(list) >= bestAmount) {
                bestSet = list;
                bestAmount = getCost(list);
            }
        }
    }

    public void checkAllSets(List<Advertisement> list){
        if (list.size() > 0){
            checkSet(list);
        }
        for (int i = 0; i < list.size(); i++){
            List<Advertisement> newSet = new ArrayList<>(list);
            newSet.remove(i);
            checkAllSets(newSet);
        }
    }

    public void printSet(List<Advertisement> list){
        System.out.println("Seconds: " + timeSeconds + "   Cost: " + getDuration(list));
        for (Advertisement element : list) {
            int oneSecondCost = (int) (element.getAmountPerOneDisplaying() * 1000 / element.getDuration());
            System.out.println("Name: " + element.getName() + "   Duration: " + element.getDuration() +
                    "   Amount: " + element.getAmountPerOneDisplaying() + "  One Second Cost: " + oneSecondCost);
        }
    }
}

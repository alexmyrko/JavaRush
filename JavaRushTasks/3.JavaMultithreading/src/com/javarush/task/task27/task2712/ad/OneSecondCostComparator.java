package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;

public class OneSecondCostComparator implements Comparator<Advertisement> {

    @Override
    public int compare(Advertisement o1, Advertisement o2) {
        return (int) (o1.amountPerOneDisplaying * 1000 / o1.getDuration() - o2.amountPerOneDisplaying * 1000 / o2.getDuration());
    }
}

package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;

public class AmountComparator implements Comparator<Advertisement> {
    @Override
    public int compare(Advertisement o1, Advertisement o2) {
        return (int) (o2.amountPerOneDisplaying - o1.amountPerOneDisplaying);
    }
}

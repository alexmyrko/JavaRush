package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits > 0)
            amountPerOneDisplaying = initialAmount / hits;
        else amountPerOneDisplaying = 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public long getAmountPerOneSecondDisplaying() {
        return getAmountPerOneDisplaying() * 1000 / getDuration();
    }

    public int getHits() {
        return hits;
    }

    public void revalidate() {
        hits--;
//        System.out.println(this.getName() + " revalidated !   Hits:" + hits);
        if (hits < 0) {
            throw new UnsupportedOperationException();
        } else if (hits == 0)
            amountPerOneDisplaying = 0;
        else
            amountPerOneDisplaying = initialAmount / hits;
    }

    @Override
    public String toString() {
        return name + " is displaying... " + getAmountPerOneDisplaying() + ", " + getAmountPerOneSecondDisplaying();
    }
}
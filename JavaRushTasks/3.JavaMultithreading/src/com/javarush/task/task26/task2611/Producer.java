package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alex on 26.04.2020.
 */
public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map){
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (true) {
                String s = "Some text for " + i;
                map.put(String.valueOf(i), s);
                i++;
                Thread.sleep(500);
            }
        }
        catch (Exception e){
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}

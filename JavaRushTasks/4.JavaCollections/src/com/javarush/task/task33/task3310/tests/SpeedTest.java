package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        long now = new Date().getTime();
        for(String s : strings){
            shortener.getId(s);
        }
        long diff = new Date().getTime() - now;
        System.out.println(diff);
        return diff;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long now = new Date().getTime();
        for(long id : ids){
            shortener.getString(id);
        }
        long diff = new Date().getTime() - now;
        System.out.println(diff);
        return diff;
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();
        for(int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
            ids.add((long)i);
        }
        long time1 = getTimeToGetIds(shortener1, origStrings, ids);
        long time2 = getTimeToGetIds(shortener2, origStrings, ids);
        Assert.assertTrue(time1 > time2);
        time1 = getTimeToGetStrings(shortener1, ids, origStrings);
        time2 = getTimeToGetStrings(shortener2, ids, origStrings);
        Assert.assertEquals(time1, time2, 30);
    }
}

package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;
import com.javarush.task.task33.task3310.tests.FunctionalTest;
import com.javarush.task.task33.task3310.tests.SpeedTest;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution.testStrategy(new HashMapStorageStrategy(), 10000);
        Solution.testStrategy(new OurHashMapStorageStrategy(), 10000);
        Solution.testStrategy(new FileStorageStrategy(), 300);
        Solution.testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        Solution.testStrategy(new HashBiMapStorageStrategy(), 10000);
        Solution.testStrategy(new DualHashBidiMapStorageStrategy(), 10000);

        FunctionalTest test = new FunctionalTest();
        test.testHashMapStorageStrategy();
        test.testFileStorageStrategy();
        test.testOurHashMapStorageStrategy();
        test.testHashBiMapStorageStrategy();
        test.testOurHashBiMapStorageStrategy();
        test.testDualHashBidiMapStorageStrategy();

        SpeedTest speedTest = new SpeedTest();
        speedTest.testHashMapStorage();
    }


    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();
        for(String string : strings)
            set.add(shortener.getId(string));
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for(Long key : keys){
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println(strategy.getClass().getSimpleName());

        Set<String> set = new HashSet<>();
        for(long i = 0; i < elementsNumber; i++)
            set.add(Helper.generateRandomString());

        Shortener shortener = new Shortener(strategy);
        long startTime = new Date().getTime();
        Set<Long> idSet = getIds(shortener, set);
        System.out.println(new Date().getTime() - startTime);
        startTime = new Date().getTime();
        Set<String> stringSet = getStrings(shortener, idSet);
        System.out.println(new Date().getTime() - startTime);

        if (set.containsAll(stringSet) && stringSet.containsAll(set))
            System.out.println("Тест пройден.");
        else System.out.println("Тест не пройден.");
    }
}

package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if (denominations.get(denomination) == null)
            denominations.put(denomination, count);
        else
            denominations.put(denomination, denominations.get(denomination) + count);
    }

    public int getTotalAmount(){
        int sum = 0;
        for (Map.Entry<Integer, Integer> denomination : denominations.entrySet()){
            sum += denomination.getKey() * denomination.getValue();
        }
        return sum;
    }

    public boolean hasMoney(){
        if (getTotalAmount() > 0)
            return true;
        else return false;
    }

    public boolean isAmountAvailable(int expectedAmount){
        if (getTotalAmount() >= expectedAmount)
            return true;
        else return false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> tempMap = new TreeMap<>(Comparator.reverseOrder());
        tempMap.putAll(denominations);
        Map<Integer, Integer> resultMap = new TreeMap<>(Comparator.reverseOrder());
        Iterator<Map.Entry<Integer, Integer>> iterator = tempMap.entrySet().iterator();
        int change = expectedAmount;
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            int nominal = entry.getKey();
            int quantity = change / nominal;
            if (quantity == 0)
                continue;
            if (entry.getValue() < quantity)
                quantity = entry.getValue();
            change = change - quantity * nominal;
            entry.setValue(entry.getValue() - quantity);
            resultMap.put(nominal, quantity);
            if (change == 0)
                break;
        }
        if (change > 0)
            throw new NotEnoughMoneyException();
        denominations.putAll(tempMap);
        denominations.entrySet().removeIf(e -> e.getValue() == 0);
        System.out.println(resultMap.toString());
        System.out.println(denominations.toString());
        return resultMap;
    }
}

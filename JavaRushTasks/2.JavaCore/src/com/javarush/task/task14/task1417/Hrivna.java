package com.javarush.task.task14.task1417;

/**
 * Created by Alexander.Myrko on 26.04.2018.
 */
public class Hrivna extends Money{
    double amount;
    public Hrivna(double amount){
    super(amount);
    }

    public String getCurrencyName(){
        return "HRN";
    }
}

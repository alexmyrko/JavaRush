package com.javarush.task.task14.task1417;

/**
 * Created by Alexander.Myrko on 26.04.2018.
 */
public class USD extends Money{
    public USD(double amount){
        super(amount);
    }

    public String getCurrencyName(){
        return "USD";
    }
}

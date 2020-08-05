package com.javarush.task.task14.task1408;

/**
 * Created by Alexander.Myrko on 30.03.2018.
 */
public class RussianHen extends Hen implements Country {
    int getCountOfEggsPerMonth(){
        return 15;
    }

    String getDescription(){
        return(super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}

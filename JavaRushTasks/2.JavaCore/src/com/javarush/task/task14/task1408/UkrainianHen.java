package com.javarush.task.task14.task1408;

/**
 * Created by Alexander.Myrko on 30.03.2018.
 */
public class UkrainianHen extends Hen implements Country {
    int getCountOfEggsPerMonth(){
        return 40;
    }

    String getDescription(){
        return(super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}

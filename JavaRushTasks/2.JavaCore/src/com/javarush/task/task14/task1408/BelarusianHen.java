package com.javarush.task.task14.task1408;

/**
 * Created by Alexander.Myrko on 30.03.2018.
 */
public class BelarusianHen extends Hen implements Country {
    int getCountOfEggsPerMonth(){
        return 25;
    }

    String getDescription(){
        return(super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}

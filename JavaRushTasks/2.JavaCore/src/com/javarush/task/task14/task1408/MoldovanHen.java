package com.javarush.task.task14.task1408;

/**
 * Created by Alexander.Myrko on 30.03.2018.
 */
public class MoldovanHen extends Hen implements Country {
    int getCountOfEggsPerMonth(){
        return 30;
    }

    String getDescription(){
        return(super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}

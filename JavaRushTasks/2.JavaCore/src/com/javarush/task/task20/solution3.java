package com.javarush.task.task20;

/**
 * Created by Alex on 01.12.2019.
 */
enum bicycles{
    GIANT, SPECIALIZED, CUBE, SCOTT
        }

class Bike{
    bicycles name;
    Bike(bicycles bc){
        this.name = bc;
    }

    public void show(){
        switch (name){
            case GIANT:
                System.out.println("Hybrid");
                break;
            case SPECIALIZED:
                System.out.println("MTB");
                break;
            case CUBE:
                System.out.println("Road");
                break;
            case SCOTT:
                System.out.println("Do not have yet");
        }

    }
}

public class solution3 {
    public static void main(String[] args) {
        for (bicycles bc : bicycles.values()){
            System.out.println(bc + " " + bc.ordinal());
        }
        Bike bike1 = new Bike(bicycles.CUBE);
        bike1.show();
    }
}

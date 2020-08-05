package com.javarush.task.task19;

/**
 * Created by Alex on 03.12.2019.
 */
abstract class Printer{
    abstract void print();
}

class Oki extends Printer{
    private int i = 2;
    void print(){
        System.out.println("Oki " + i);
    }
}

class HP extends Printer{
    private int i = 5;
    void print(){
        System.out.println("HP " + i);
    }
}

public class Druk {
    public static void main(String[] args) {
        HP hp = new HP();
        hp.print();
    }
}

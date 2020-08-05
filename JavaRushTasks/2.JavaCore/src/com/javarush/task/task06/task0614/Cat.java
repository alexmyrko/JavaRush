package com.javarush.task.task06.task0614;


import java.util.ArrayList;
import java.util.Iterator;

/*
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            cats.add(new Cat());
        }
        printCats();
    }

    public static void printCats() {
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

package com.javarush.task.task12.task1204;

/* Или «Кошка», или «Собака», или «Птица», или «Лампа»
Написать метод, который определяет, объект какого класса ему передали, и выводит на экран одну из надписей: Кошка, Собака, Птица, Лампа.

*/

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        if (o instanceof Cat)
            System.out.println("Cat");
        if (o instanceof Dog)
            System.out.println("Dog");
        if (o instanceof Lamp)
            System.out.println("Lamp");
        if (o instanceof Bird)
            System.out.println("Bird");
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
package com.javarush.task.task12.task1219;

/* Fly, Run, Swim для классов Human, Duck, Penguin, Airplane
Есть public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавь эти интерфейсы классам Human(человек), Duck(утка), Penguin(пингвин), Airplane(самолет).
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Run
    {
        public void run();
    }

    public interface Swim
    {
        public void swim();
    }


    public abstract class Human implements Run, Swim
    {

    }

    public abstract class Duck implements Fly, Run, Swim
    {

    }

    public abstract class Penguin implements Run, Swim
    {

    }

    public abstract class Airplane implements Fly
    {

    }
}

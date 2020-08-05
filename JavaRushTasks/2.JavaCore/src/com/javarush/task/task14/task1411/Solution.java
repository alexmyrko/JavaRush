package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution implements  Person{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        while (true)
        {
            key = reader.readLine();
            if (key.equals("user"))
                person = new User();
            else if (key.equals("loser"))
                person = new Loser();
            else if (key.equals("coder"))
                person = new Coder();
            else if (key.equals("proger"))
                person = new Proger();
            else break;
            doWork(person); //вызываем doWork
        }
    }

    public static void doWork(Person person) {
        if (person instanceof User)
            ((User)person).live();
        else if (person instanceof Loser)
            ((Loser)person).doNothing();
        else if (person instanceof Coder)
            ((Coder)person).coding();
        else if (person instanceof Proger)
            ((Proger)person).enjoy();
    }
}

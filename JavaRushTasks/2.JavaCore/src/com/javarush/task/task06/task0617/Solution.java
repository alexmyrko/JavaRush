package com.javarush.task.task06.task0617;

/**
 * Created by Alex on 01.01.2020.
 */
public class Solution {
    public static class Idea{
        public String getDescription(){
            return "text";
        }
    }
    public static void printIdea(Idea idea){
        System.out.println(idea.getDescription());
    }
    public static void main(String[] args) {
        printIdea(new Idea());
    }

    //напишите тут ваш код
}

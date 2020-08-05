package com.javarush.task.task13.task1311_2;

/*
Нанимаем переводчика
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        EnglishTranslator englishTranslator = new EnglishTranslator();
        System.out.println(englishTranslator.translate());
    }

    public static abstract class Translator {
        public abstract String getLanguage();

        public String translate() {
            return "Я переводчик с " + getLanguage();
        }
    }

    public static class EnglishTranslator extends Translator{
        public String getLanguage(){
            return "Я переводчик с английского";
        }
    }

}
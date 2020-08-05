package com.javarush.task.task10.task1001;

/**
 * Created by alex on 11.03.2018.
 */
public class Solution {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
            public String getName() {
                return "Я - не корова. Я кит.";
            }
    }
}


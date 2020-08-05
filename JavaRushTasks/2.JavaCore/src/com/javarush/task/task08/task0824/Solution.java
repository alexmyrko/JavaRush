package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/*
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> children1 = new ArrayList<>();
        ArrayList<Human> children2 = new ArrayList<>();
        Human child1 = new Human("Lisa", false, 8);
        Human child2 = new Human("Hania", false, 2);
        children1.add(child1);
        children1.add(child2);
        Human father = new Human("Alex", true, 39, children1);
        Human mother = new Human("Iryna", false, 33, children1);

        children2.add(father);
        children2.add(mother);
        Human gf1 = new Human ("Hrysha", true, 67, children2);
        Human gf2 = new Human ("Ivan", true, 74, children2);

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(gf1.toString());
        System.out.println(gf2.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

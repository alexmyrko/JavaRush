package com.javarush.task.task07.task0724;

/**
 * Created by Alex on 04.01.2020.
 */
public class Solution {
    public static void main(String[] args) {
        Human gf1 = new Human("Ivan", true, 78, null, null);
        Human gf2 = new Human("Hrysha", true, 75, null, null);
        Human gm1 = new Human("Alla", false, 75, null, null);
        Human gm2 = new Human("Lidia", false, 72, null, null);
        Human father = new Human("Sasha", true, 38, gf2, gm2);
        Human mother = new Human("Ira", false, 33, gf1, gm1);
        Human child1 = new Human("Lisa", false, 8, father, mother);
        Human child2 = new Human("baby", true, 1, father, mother);
        System.out.println(gf1.toString());
        System.out.println(gf2.toString());
        System.out.println(gm1.toString());
        System.out.println(gm2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}

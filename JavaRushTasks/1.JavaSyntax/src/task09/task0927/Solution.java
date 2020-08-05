package com.javarush.task.task09.task0927;

/**
 Есть класс кот – Cat, с полем «имя» (String).
 Создать словарь Map<String, Cat> и добавить туда 10 котов в виде «Имя»-«Кот».
 Получить из Map множество(Set) всех котов и вывести его на экран.
 */

        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.Map;
        import java.util.Set;

/*
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        map.put("Vaska", new Cat("Vaska"));
        map.put("Valera", new Cat("Valera"));
        map.put("Bars", new Cat("Bars"));
        map.put("Murzik", new Cat("Murzik"));
        map.put("Dina", new Cat("Dina"));
        map.put("Amanda", new Cat("Amanda"));
        map.put("Kit", new Cat("Kit"));
        map.put("Danylo", new Cat("Danylo"));
        map.put("Splet", new Cat("Splet"));
        map.put("Mars`", new Cat("Mars"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        HashSet<Cat> cats = new HashSet<Cat>();
        for (Cat value : map.values()){
            cats.add(value);
        }
        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }

}
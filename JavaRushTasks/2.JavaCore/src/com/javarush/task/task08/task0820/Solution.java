package com.javarush.task.task08.task0820;

/**
 * Created by Alex on 19.01.2020.
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);
        System.out.println();
        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();

        for (int i = 0; i < 3; i++){
            result.add(new Cat());
        }
        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> dogs = new HashSet<>();
        for (int i = 0; i < 4; i++){
            dogs.add(new Dog());
        }
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> animals = new HashSet<>();
        for (Cat cat : cats
             ) {
            animals.add(cat);
        }

        for (Dog dog : dogs){
            animals.add(dog);
        }
        return animals;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Iterator it = pets.iterator();
        while(it.hasNext()){
            if (it.next() instanceof Cat){
                it.remove();
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        for (Object pet : pets){
            System.out.println(pet);
        }
    }

    public static class Dog{
    }

    public static class Cat{
    }
}

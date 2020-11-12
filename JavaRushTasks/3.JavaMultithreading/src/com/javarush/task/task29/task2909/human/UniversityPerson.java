package com.javarush.task.task29.task2909.human;

/**
 * Created by Alex on 16.04.2020.
 */
public class UniversityPerson extends Human{
    public UniversityPerson(String name, int age){
        super(name, age);
    }

    private University university;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

}

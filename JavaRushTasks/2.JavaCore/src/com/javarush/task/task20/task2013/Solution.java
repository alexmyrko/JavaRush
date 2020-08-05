package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){
            super();
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/task2013.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/task2013.txt"));
        Person me = new Person("Oleksandr", "Myrko", 39);
        Person she = new Person("Maryna", "Kapran", 29);
        Person myFather = new Person("Hryhoriy", "Myrko", 67);
        Person myChild = new Person("Lisa", "Myrko", 8);
        Person myCat = new Person("Kote", "Churchill", 2);
        List<Person> myChildren = new ArrayList<>();
        myChildren.add(myChild);
        myChildren.add(myCat);
        me.setChildren(myChildren);
        me.setFather(myFather);
        me.writeExternal(out);
        me.readExternal(in);
    }
}

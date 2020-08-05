package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution{

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outStream  = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outStream);

        Person person = new Person("Oleksandr", "Myrko", "Ukraine", Sex.MALE);
        oos.writeObject(person);
        oos.flush();

        ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(inStream);

        Person person2 = (Person) ois.readObject();
        System.out.println(person2.firstName);
        System.out.println(person2.lastName);
        System.out.println(person2.country);
        System.out.println(person2.sex);
    }
}

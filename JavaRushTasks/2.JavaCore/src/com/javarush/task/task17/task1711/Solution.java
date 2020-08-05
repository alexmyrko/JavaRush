package com.javarush.task.task17.task1711;

import com.javarush.task.task17.task1710.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static SimpleDateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        switch (args[0]){
            case "-c": synchronized (allPeople) {
                    create(args);
                }
                break;
            case "-u": synchronized (allPeople){
                update(args);
                }
                break;
            case "-d": synchronized (allPeople){
                delete(args);
                }
                break;
            case "-i": synchronized (allPeople) {
                show(args);
            }
                break;
        }

    }

    public static void create(String[] arguments) throws ParseException {
            for (int i = 1; i < arguments.length; i = i + 3) {
                String name = arguments[i];
                Date date = dateFormatInput.parse(arguments[i + 2]);
                if (arguments[i + 1].equals("м")) allPeople.add(Person.createMale(name, date));
                else if (arguments[i + 1].equals("ж")) allPeople.add(Person.createFemale(name, date));
                System.out.println(allPeople.size() - 1);
        }
    }

    public static void update(String[] arguments) throws ParseException{
            for (int i = 1; i < arguments.length; i = i + 4) {
                int index = Integer.parseInt(arguments[i]);
                String name = arguments[i + 1];
                Date date = dateFormatInput.parse(arguments[i + 3]);
                Person thisPerson = allPeople.get(index);
                thisPerson.setName(name);
                if (arguments[i + 2] == "м") thisPerson.setSex(Sex.MALE);
                else if (arguments[i + 2] == "ж") thisPerson.setSex(Sex.FEMALE);
                thisPerson.setBirthDate(date);
        }
    }

    public static void delete(String[] arguments){
            for (int i = 1; i < arguments.length; i++) {
                int index = Integer.parseInt(arguments[i]);
                Person thisPerson = allPeople.get(index);
                thisPerson.setName(null);
                thisPerson.setSex(null);
                thisPerson.setBirthDate(null);
            }
    }

    public static void show(String[] arguments) {
            for (int i = 1; i < arguments.length; i++) {
                int index = Integer.parseInt(arguments[i]);
                Person thisPerson = allPeople.get(index);
                String thisDate = dateFormatOutput.format(thisPerson.getBirthDate());
                String thisSex = null;
                if (thisPerson.getSex() == Sex.MALE) thisSex = "м";
                else if (thisPerson.getSex() == Sex.FEMALE) thisSex = "ж";
                System.out.println(thisPerson.getName() + " " + thisSex + " " + thisDate);
            }
    }
}

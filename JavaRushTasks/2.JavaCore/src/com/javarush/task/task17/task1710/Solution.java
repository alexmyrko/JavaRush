package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{


        if (args[0].equals("-c")) create(args);
        else if (args[0].equals("-u")) update(args);
        else if (args[0].equals("-d")) delete(args[1]);
        else if (args[0].equals("-i"))  show(args[1]);

        }

    public static void create(String[] arguments) throws ParseException{
        String name = arguments[1];
        Date date = dateFormatInput.parse(arguments[3]);
        if (arguments[2].equals("м")) allPeople.add(Person.createMale(name, date));
        else if (arguments[2].equals("ж")) allPeople.add(Person.createFemale(name, date));
        System.out.println(allPeople.size()-1);
    }

    public static void update(String[] arguments) throws ParseException{
    int index = Integer.parseInt(arguments[1]);
    String name = arguments[2];
    Date date = dateFormatInput.parse(arguments[4]);
    Person thisPerson = allPeople.get(index);
    thisPerson.setName(name);
    if (arguments[3] == "м") thisPerson.setSex(Sex.MALE);
    else if (arguments[3] == "ж") thisPerson.setSex(Sex.FEMALE);
    thisPerson.setBirthDate(date);
    }

    public static void delete(String id){
        int index = Integer.parseInt(id);
        Person thisPerson = allPeople.get(index);
        thisPerson.setName(null);
        thisPerson.setSex(null);
        thisPerson.setBirthDate(null);
    }

    public static void show(String id){
        int index = Integer.parseInt(id);
        Person thisPerson = allPeople.get(index);
        String thisDate = dateFormatOutput.format(thisPerson.getBirthDate());
        String thisSex = null;
        if (thisPerson.getSex() == Sex.MALE) thisSex = "м";
        else if (thisPerson.getSex() == Sex.FEMALE) thisSex = "ж";
        System.out.println(thisPerson.getName() + " " + thisSex + " " + thisDate);
    }


}

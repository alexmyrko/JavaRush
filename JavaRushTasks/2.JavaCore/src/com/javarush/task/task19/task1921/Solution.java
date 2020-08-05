package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        String[] data;
        String name;
        String day = null;
        String month = null;
        String year = null;

        while((line = reader.readLine()) != null){
            int count = 0;
            data = line.split(" ");
            name = data[0];
            for (int i = 1; i < data.length; i++) {
                if(data[i].matches("\\D+"))
                    name = name.concat(" " + data[i]);
                else if (data[i].matches("\\d+") && (count == 0)){
                    day = data[i];
                    count++;
                }
                else if (data[i].matches("\\d+") && count == 1){
                    month = data[i];
                    count++;
                }
                else if (data[i].matches("\\d+") && count == 2){
                    year = data[i];
                } else break;
            }
            Date date = new SimpleDateFormat("dd/MM/yyy").parse(day + "/" + month + "/" + year);
            PEOPLE.add(new Person(name, date));
        }
        reader.close();
        fileReader.close();
    }
}

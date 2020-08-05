package com.javarush.task.task19.task1904;

import com.javarush.task.task17.task1710.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
/*        PersonScanner scanner2 = new PersonScannerAdapter(new Scanner(new File("D:\\file9.txt")));
        Person person2 = scanner2.read();
        System.out.println(person2);*/
    }

    public static class PersonScannerAdapter implements PersonScanner{
    private final Scanner fileScanner;
    PersonScannerAdapter (Scanner scanner){
        this.fileScanner = scanner;
    }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        public Person read() throws ParseException {
        String line = fileScanner.nextLine();
        String[] elements = line.split(" ");
        String lastName = elements[0];
        String firstName = elements[1];
        String middleName = elements[2];
        String stringDate = elements[3] + " " + elements[4] + " " + elements[5];
        Date date = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH).parse(stringDate);
        return new Person(firstName, middleName, lastName, date);
        }
    }
}

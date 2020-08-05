package com.javarush.task.task19.task1904_;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        Scanner scanner;
        PersonScannerAdapter (Scanner scanner){
            this.scanner= scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String s = scanner.nextLine();
            String[] parts = s.split(" ");
            Date date = new Date();
            String sDate = parts[3] + "/" + parts[4] + "/" + parts[5];
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            date = sdf.parse(sDate);
            return new Person(parts[1], parts[0], parts[2], date);
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }

    public static void main(String[] args) {

    }
}
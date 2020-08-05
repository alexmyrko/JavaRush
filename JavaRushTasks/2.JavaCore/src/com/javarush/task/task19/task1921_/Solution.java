package com.javarush.task.task19.task1921_;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String s;
        String date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("##");
        while ((s = reader.readLine()) != null){
            String[] parts = s.split(" ");
            String day = decimalFormat.format(Integer.parseInt(parts[1]));
            String month = decimalFormat.format(Integer.parseInt(parts[2]));
            date = day + " " + month + " " + parts[3];
            PEOPLE.add(new Person(parts[0], sdf.parse(date)));
        }

        for(Person person : PEOPLE){
            System.out.println(person.getName() + " " + person.getBirthday());
        }
    }

}
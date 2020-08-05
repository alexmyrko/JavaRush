package com.javarush.task.task20.task2003_;
import org.omg.CORBA.portable.*;

import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties prop = new Properties();

    public void fillInPropertiesMap() throws Exception {
        FileInputStream fis = new FileInputStream("D:/properties.txt");
        FileOutputStream fos = new FileOutputStream("D:/properties2.txt");
        load(fis);
        save(fos);
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Set<String> keys = properties.keySet();
        for (String key : keys){
            String s = key + " " + properties.get(key);
//            System.out.println(s);
            prop.put(key, properties.get(key));
        }
        prop.store(outputStream, "Store these properties");
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        prop.load(inputStream);
        Set keys = prop.keySet();
        Iterator iterator = keys.iterator();
        while(iterator.hasNext()){
            String s = (String) iterator.next();
            properties.put(s, prop.getProperty(s));
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        System.out.println(properties);
    }
}
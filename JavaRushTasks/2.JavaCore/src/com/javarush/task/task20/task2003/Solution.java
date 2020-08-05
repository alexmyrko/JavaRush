package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties props = new Properties();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        load(inputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for (Map.Entry  map : properties.entrySet()
             ) {
            props.put(map.getKey(), map.getValue());
        }
        props.save(outputStream, null);
        outputStream.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        props.load(inputStream);
        Set<String> list = props.stringPropertyNames();
//        Set set = props.entrySet();
//        Iterator iterator = set.iterator();
        for(String l : list){
            properties.put(l, props.getProperty(l));
        }
    }

    public static void main(String[] args) {

    }
}

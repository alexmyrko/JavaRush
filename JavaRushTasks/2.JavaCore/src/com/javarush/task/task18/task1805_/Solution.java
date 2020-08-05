package com.javarush.task.task18.task1805_;

import javafx.collections.transformation.SortedList;

import java.io.FileInputStream;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inStream = new FileInputStream("D:/text11.txt");
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        while(inStream.available() > 0){
            set.add(inStream.read());
        }
        for (Integer i : set){
            list.add(i);
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        inStream.close();
    }
}
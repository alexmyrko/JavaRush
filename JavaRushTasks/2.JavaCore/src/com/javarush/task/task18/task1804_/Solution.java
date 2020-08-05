package com.javarush.task.task18.task1804_;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с минимальним количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        FileInputStream inStream = new FileInputStream("D:/text11.txt");
        Integer data = null;
        int max = 0;
        while(inStream.available()>0){
            data = inStream.read();
            if (map.get(data) == null)
                map.put(data, 1);
            else
                map.put(data, map.get(data) + 1);
            if (map.get(data) > max)
                max = map.get(data);
        }
        int min = max;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() < min)
                min = pair.getValue();
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue().equals(min))
                System.out.println((char)(int)pair.getKey());
        }
        System.out.println(map);
        inStream.close();
    }
}
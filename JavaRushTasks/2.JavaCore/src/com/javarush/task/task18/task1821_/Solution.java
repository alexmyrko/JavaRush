package com.javarush.task.task18.task1821_;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inStream = new FileInputStream("D:/file6.txt");
        Map<Integer, Integer> map = new HashMap<>();
        int data;
        while(inStream.available() > 0){
            data = inStream.read();
            if (map.get(data) == null)
                map.put(data, 1);
            else
                map.put(data, map.get(data) + 1);
        }
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (Integer i : set){
            list.add(i);
        }
        Collections.sort(list);
        System.out.println(list);
        for (Integer l : list){
            System.out.println(l + " - " + map.get(l));
        }
        System.out.println(map);

    }
}
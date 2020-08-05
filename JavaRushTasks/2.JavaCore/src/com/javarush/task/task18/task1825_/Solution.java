package com.javarush.task.task18.task1825_;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream;
        FileOutputStream outStream = new FileOutputStream("D:/result.txt", true);
        Map<Integer,byte[]> map = new HashMap<>();
        String fileName = null;
        String[] nameParts;
        while(!(fileName = reader.readLine()).equals("end")){
            nameParts = fileName.split(".part");
            int index = Integer.parseInt(nameParts[1]);
            inStream = new FileInputStream(fileName);
            byte[] buffer = new byte[inStream.available()];
            inStream.read(buffer);
            map.put(index, buffer);
            inStream.close();
        }
        Set<Integer> set = new HashSet<>();
        set = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (Integer index : set){
            list.add(index);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++){
            byte[] buffer = map.get(list.get(i));
            outStream.write(buffer);
        }
        outStream.close();
    }
}
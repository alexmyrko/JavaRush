package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader1 = new FileReader(reader.readLine());
        FileReader fileReader2 = new FileReader(reader.readLine());
        reader.close();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String line;
        reader = new BufferedReader(fileReader1);
        while ((line = reader.readLine()) != null){
            list1.add(line);
        }
        reader = new BufferedReader(fileReader2);
        while ((line = reader.readLine()) != null){
            list2.add(line);
        }
        int count1 = 0, count2 = 0;
        int size1 = list1.size(), size2 = list2.size();

        while ((count1 < size1) && (count2 < size2)){
            if (list1.get(count1).equals(list2.get(count2))) {
                lines.add(new LineItem(Type.SAME, list1.get(count1)));
                count1++;
                count2++;
            }
            if (((count2 + 1) < size2) && list1.get(count1).equals(list2.get(count2+1))){
                lines.add(new LineItem(Type.ADDED, list2.get(count2++)));
            }
            if (((count1 + 1) < size1) && list1.get(count1+1).equals(list2.get(count2))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(count1++)));
            }
        }

        if ((count2 < size2) && (count1 == size1)) {
            lines.add(new LineItem(Type.ADDED, list2.get(count2)));
        }
        else if ((count1 < size1) && (count2 == size2)) {
            {lines.add(new LineItem(Type.REMOVED, list1.get(count1)));}
        }

        for (LineItem l : lines
             ) {
            System.out.println(l.type + " " + l.line);
        }

        reader.close();
        fileReader1.close();
        fileReader2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

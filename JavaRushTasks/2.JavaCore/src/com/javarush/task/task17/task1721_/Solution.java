package com.javarush.task.task17.task1721_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        String s;
        reader = new BufferedReader(new FileReader(file1));
        while((s = reader.readLine()) != null){
            allLines.add(s);
        }
        reader.close();

        reader = new BufferedReader(new FileReader(file2));
        while ((s = reader.readLine()) != null){
            forRemoveLines.add(s);
        }
        reader.close();
        Solution solution = new Solution();
        solution.joinData();

        for (String line : allLines){
            System.out.println(line);
        }
    }

    public void joinData () throws CorruptedDataException {
        boolean containsAll = false;
        boolean containsNotAll = false;
        if (allLines.containsAll(forRemoveLines)) {
            containsAll = true;
            allLines.removeAll(forRemoveLines);
        } else {
            for (String line : forRemoveLines) {
                if (allLines.contains(line))
                    containsNotAll = true;
            }
            if (!containsNotAll)
                allLines.clear();
            throw new CorruptedDataException();
        }

        System.out.println(containsAll);
        System.out.println(containsNotAll);
    }
}

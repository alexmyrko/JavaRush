package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException{
        boolean isRead = false;
        String line = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        BufferedReader stream1 = new BufferedReader(new FileReader(filename1));
        BufferedReader stream2 = new BufferedReader(new FileReader(filename2));
        while(!isRead) {
            line = stream1.readLine();
            if (line != null) allLines.add(line);
            else isRead = true;
        }
        isRead = false;

        while(!isRead) {
            line = stream2.readLine();
            if (line != null) forRemoveLines.add(line);
            else isRead = true;
        }

        Solution solution = new Solution();
        solution.joinData();

        stream1.close();
        stream2.close();
        reader.close();
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
              allLines.clear();
              throw new CorruptedDataException();
        }
    }
}

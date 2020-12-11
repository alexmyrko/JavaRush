package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileNames = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();
        Collections.addAll(queue, new File(root).listFiles());
        while(!queue.isEmpty()){
            File takenFile = queue.remove();
            if (takenFile.isFile()){
                fileNames.add(takenFile.getAbsolutePath());
            } else Collections.addAll(queue, takenFile.listFiles());
        }
        return fileNames;
    }

    public static void main(String[] args) {

    }
}

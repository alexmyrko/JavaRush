package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File dest = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(resultFileAbsolutePath))
            FileUtils.renameFile(resultFileAbsolutePath, dest);
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        FileInputStream fileInputStream;
        Map<String, String> map = new TreeMap<>();
        lookingFiles(path, map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            fileInputStream = new FileInputStream(entry.getValue());
            writeToFile(fileInputStream, fileOutputStream);
            fileInputStream.close();
        }
//            System.out.println(map);
        fileOutputStream.close();
    }

    public static void lookingFiles(File path, Map<String, String> map){
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isFile() && file.length() <= 50 && !Paths.get(file.getAbsolutePath()).equals(Paths.get("C://JAVA/task31/allFilesContent.txt"))) {
                map.put(file.getName(), file.getAbsolutePath());
            }
            else if (file.isDirectory()){
                    lookingFiles(file, map);
            }
        }
    }

    public static void writeToFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws IOException {
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }
        fileOutputStream.write('\n');
    }

}

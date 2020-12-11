package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        Arrays.sort(args, 1, args.length);
        Vector<FileInputStream> vector = new Vector<>();
        try {
            for (int i = 1; i < args.length; i++) {
                vector.add(new FileInputStream(args[i]));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try(ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(vector.elements()));
            FileOutputStream fileOutputStream = new FileOutputStream(args[0]))
            {
            byte[] buffer = new byte[2048];
            int len;
            while(zipInputStream.getNextEntry() != null){
                while((len = zipInputStream.read(buffer)) > 0){
                    fileOutputStream.write(buffer, 0, len);
                    fileOutputStream.flush();
                }
                zipInputStream.closeEntry();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

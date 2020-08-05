package com.javarush.task.task18.task1814_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws FileNotFoundException {
        super(fileName);
        String[] parts = fileName.split("\\.");
        for (String p : parts){
            System.out.println(p);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        new TxtInputStream("D:/file5.txt");
    }}

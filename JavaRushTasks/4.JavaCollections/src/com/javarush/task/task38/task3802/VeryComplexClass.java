package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.io.FileInputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        File file = new File("");
        FileInputStream inputStream = new FileInputStream(file);
        System.out.println(file.length());
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}

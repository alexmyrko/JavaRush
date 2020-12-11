package com.javarush.task.task36.task3606;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{
    private String filePath;

    public MyClassLoader(ClassLoader classLoader, String filePath){
        super(classLoader);
        this.filePath = filePath;
    }

    protected Class<?> findClass(String className){
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            try {
                return super.findClass(className);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
        return defineClass(null, bytes, 0, bytes.length);
    }
}

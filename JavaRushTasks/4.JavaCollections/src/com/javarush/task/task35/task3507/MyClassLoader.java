package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{
    private String filePath;

    public MyClassLoader(ClassLoader parent, String filePath) {
        super(parent);
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            return defineClass(null, bytes, 0, bytes.length);
        } catch (IOException e) {
            return super.findClass(className);
        }
    }
}

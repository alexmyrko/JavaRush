package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Animal> set = new HashSet<>();
        File[] filePaths = new File(pathToAnimals).listFiles();

        for(File filePath : filePaths) {
            MyClassLoader classLoader = new MyClassLoader(ClassLoader.getSystemClassLoader(), filePath.getAbsolutePath());
            String className = filePath.getName().split(".class")[0];
            Class<?> clazz = classLoader.loadClass(className);
//            Class clazz2 = Class.forName("com.javarush.task.task35.task3507.data.Sheep");
            if (!Animal.class.isAssignableFrom(clazz))
                continue;
            Constructor[] constructors = clazz.getConstructors();
            for(Constructor constructor : constructors){
                if(constructor.getParameterCount() == 0 && constructor.getModifiers() == Modifier.PUBLIC)
                    set.add((Animal) constructor.newInstance());
            }
        }
        return set;
    }
}

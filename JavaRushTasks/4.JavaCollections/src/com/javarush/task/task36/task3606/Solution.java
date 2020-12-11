package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File[] files = new File(packageName).listFiles();
        for (File file : files){
            if (file.getName().contains(".class")) {
                MyClassLoader classLoader = new MyClassLoader(ClassLoader.getSystemClassLoader(), file.getAbsolutePath());
                String className = file.getName().split(".class")[0];
                Class<?> clazz = classLoader.loadClass(className);
//                System.out.println(file + " " + clazz.getSimpleName());
                if (!HiddenClass.class.isAssignableFrom(clazz))
                    continue;
                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                } catch (Exception e){
                    continue;
                }
                hiddenClasses.add(clazz);
            }
        }
        System.out.println(this.packageName);

    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for(Class clazz : hiddenClasses){
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                Constructor constructor = null;
                try {
                    constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    return (HiddenClass) constructor.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}


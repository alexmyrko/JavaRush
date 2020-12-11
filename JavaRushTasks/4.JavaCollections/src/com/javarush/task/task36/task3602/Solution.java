package com.javarush.task.task36.task3602;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws NoSuchMethodException {
        boolean isPrivate;
        boolean isStatic;
        boolean accessFromIndexException;
        boolean implementsList;

        Class[] classes = Collections.class.getDeclaredClasses();
        for(Class clazz : classes){
            if (!(List.class.isAssignableFrom(clazz) && List.class.isAssignableFrom(clazz.getSuperclass())))
                continue;
            if (Modifier.isPrivate(clazz.getModifiers()) && Modifier.isStatic(clazz.getModifiers())) {
                Method method;
                try {
                    method = clazz.getDeclaredMethod("get", int.class);
                    method.setAccessible(true);
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    method.invoke(constructor.newInstance(),0);
                } catch (InvocationTargetException e){
//                    System.out.println(" Cause   !!!" + e.getCause());
                    return clazz;
                } catch (IllegalAccessException e) {
                } catch (InstantiationException e) {
                } catch (NoSuchMethodException e){
                }
            }
        }
        return null;
    }
}

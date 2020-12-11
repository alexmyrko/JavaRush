package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            Annotation[] annotations = c.getAnnotations();
            for(Annotation annotation : annotations){
                System.out.println(annotation.toString());
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class[] values = annotation.value();
            System.out.println(Arrays.toString(values));
                return true;
            }
        return false;
    }
}

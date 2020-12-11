package com.javarush.task.task35.task3501;

public class GenericStatic {
    public static <Number>Number someStaticMethod(Object genericObject) {
        System.out.println(genericObject);
        return (Number) genericObject;
    }
}

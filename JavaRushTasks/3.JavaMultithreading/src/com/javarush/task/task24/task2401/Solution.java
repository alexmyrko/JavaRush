package com.javarush.task.task24.task2401;

/* 
Создание своего интерфейса-маркера
*/
public class Solution {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarker obj = new SelfInterfaceMarker(){
            public void m1(){
                System.out.println("m1");
            }
        };
        Util.testClass(obj);
    }

}

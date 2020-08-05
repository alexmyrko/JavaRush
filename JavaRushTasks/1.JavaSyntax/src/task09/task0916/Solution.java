package com.javarush.task.task09.task0916;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by alex on 24.02.2018.
 */
public class Solution {
    public static void main(String[] args) {
        processExceptions(new Solution());

    }

    public static void processExceptions(Solution obj) {
        try {
            obj.method1();
            obj.method2();
            obj.method3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}

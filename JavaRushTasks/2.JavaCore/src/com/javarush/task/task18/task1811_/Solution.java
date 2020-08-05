package com.javarush.task.task18.task1811_;

/* Wrapper (Decorator)
Разберись, что делает программа
Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl
*/

public class Solution {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorMyRunnableImpl implements Runnable{
        private Runnable component;
        DecoratorMyRunnableImpl(Runnable component){
            this.component = component;
        }

        @Override
        public void run() {
            System.out.println("My RunnableImpl body");
            component.run();
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }

}
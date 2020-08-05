package com.javarush.task.task16.task1618_;

/**
 * Created by Alex on 01.02.2020.
 */
/* Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread test = new TestThread();
        Thread.sleep(2000);
        test.interrupt();
        //Add your code here - добавь код тут
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }
    }
}
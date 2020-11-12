package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution extends Thread{
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread t1 = new Thread(){
            public void run(){
                synchronized (o1){
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        Thread.sleep(200);
        t2.start();
        Thread.sleep(2000);
        if (t2.getState() == State.BLOCKED)
            return false;
        else return true;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}

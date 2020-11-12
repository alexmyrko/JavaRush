package com.javarush.task.task26.task2605;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* 
Трудолюбие - душа всякого дела и залог благосостояния
*/
public class Solution {
    private static ScheduledExecutorService interruptScheduledExecutor;
    private static Thread taskThread;
    private static RethrowableTask task;

    public static void main(String[] args) throws Exception {
        runTaskBySchedule(new Runnable() {
                              @Override
                              public void run() {
                                  System.out.println("A");
                                  throw new RuntimeException("it's test");
                              }
                          }, 3_000, TimeUnit.MILLISECONDS
        );

        interruptScheduledExecutor.shutdown();
    }

    public static void runTaskBySchedule(final Runnable runnable, long timeout, TimeUnit unit) throws Exception {
        task = new RethrowableTask(runnable);
        taskThread = new Thread(task);
        taskThread.start();
//        Thread.sleep(5);
        System.out.println("Not started yet");
        interruptScheduledExecutor = Executors.newScheduledThreadPool(1);
        interruptScheduledExecutor.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
                System.out.println("Interrupt");
            }
        }, 5000, unit);
        Thread.sleep(unit.toMillis(10000));
        try {
            task.rethrow();
        } catch (Throwable throwable) {
//            System.out.println("Catched in Rethrow");
            System.out.println(throwable.getMessage());
        }
    }

    public static class RethrowableTask implements Runnable {
        private volatile Throwable throwable;
        private Runnable runnable;

        public RethrowableTask(Runnable runnable) {
            this.runnable = runnable;
        }

        public void run() {
            try {
                runnable.run();
            } catch (Throwable throwable) {
                this.throwable = throwable;
                System.out.println("Catch Throwable" + "\n" + throwable);
            }
        }

        public void rethrow() throws Exception {
            if (throwable != null) {
                System.out.println("B");
                throw new Exception(throwable);
            }
        }
    }
}

package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Alex on 26.04.2020.
 */
public class Consumer implements Runnable{
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println(queue.take());
            }
        } catch (InterruptedException e) {
//            System.out.println("End consumer");
            e.printStackTrace();
        }

    }
}

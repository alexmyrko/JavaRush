package com.javarush.task.task25.task2506;

/**
 * Created by Alex on 01.04.2020.
 */
public class LoggingStateThread extends Thread{
    Thread target;
    State state;
    LoggingStateThread(Thread target){
        this.target = target;
    }

    @Override
    public void run() {
        while (true)
        if (target.getState() != state){
            state = target.getState();
            System.out.println(state);
            if (state == State.TERMINATED)
                break;
        }
    }
}

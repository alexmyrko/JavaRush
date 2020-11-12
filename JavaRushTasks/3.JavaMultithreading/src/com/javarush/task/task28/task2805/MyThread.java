package com.javarush.task.task28.task2805;

public class MyThread extends Thread{
    static volatile int priority = 0;

    public MyThread() {
        Thread t = this;
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        Thread t = this;
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        Thread t = this;
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        Thread t= this;
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        Thread t = this;
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        Thread t = this;
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        Thread t = this;
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        Thread t = this;
        setPriority();
    }

    void setPriority(){
        this.setPriority(priority++ % 10 + 1);
    }
}

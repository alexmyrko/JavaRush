package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {


    }

    static{
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());


    }

    public static class ThreadOne extends Thread{
    public ThreadOne() {}
        public void run() {
            while (true) {
            }
        }
    }

    public static class ThreadTwo extends Thread{
        public ThreadTwo() {}
        public void run() {
            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            while (!this.isInterrupted()) {
            }
        }
    }


    public static class ThreadThree extends Thread{
    public ThreadThree(){
//        this.start();
    }
    public void run(){
        while(true){
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }

    public static class ThreadFour extends Thread implements Message{
    public ThreadFour(){
    }
    @Override
    public void showWarning(){
        this.interrupt();
    }
    public void run(){
        while(!isInterrupted()) {
            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }

    public static class ThreadFive extends Thread{
        private String line = "";
        private Integer number = null;
        private int sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        public ThreadFive(){
    }
    public void run() {
        while (!line.equals("N")) {
            try {
//                System.out.println(line);
                line = reader.readLine();
                number = Integer.parseInt(line);
                sum += number;
                } catch (Exception e) {
                System.out.println(line);
            }
                }
        System.out.println(sum);
        this.interrupt();
        }
    }

}
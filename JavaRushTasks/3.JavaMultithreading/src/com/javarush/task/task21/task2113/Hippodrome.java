package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 08.03.2020.
 */
public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public List<Horse> getHorses(){
        return horses;
    }
    public static Hippodrome game;
    Hippodrome(List<Horse> newHorses){
        horses = newHorses;
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("Wind", 3, 0);
        Horse horse2 = new Horse("Snow", 3, 0);
        Horse horse3 = new Horse("Amber", 3, 0);
        List<Horse> initialHoreses = new ArrayList<>();
        initialHoreses.add(horse1);
        initialHoreses.add(horse2);
        initialHoreses.add(horse3);
        game = new Hippodrome(initialHoreses);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i  < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        double max = 0;
        Horse winner = null;
        for (Horse horse : horses){
            if (horse.getDistance() > max) {
                max = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.printf("Winner is " + getWinner().name + "!");
    }
}

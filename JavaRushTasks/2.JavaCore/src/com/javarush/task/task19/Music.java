package com.javarush.task.task19;

/**
 * Created by Alex on 03.12.2019.
 */
enum Note {Do, Re, Mi}

interface Instrument{
    void play(Note n);
    String what();
}

class Wind implements Instrument{
    public void play(Note n){
        System.out.println("Wind play " + n);
    }
    public String what(){return "Wind"; }
}

class Stringed implements Instrument{
    public void play(Note n){
        System.out.println("Stringed play " + n);
    }
    public String what(){ return "Stringed"; }
}

class Brass extends Wind{
   public void play(Note n){
        System.out.println("Brass play " + n);
    }
    public String what(){ return "Brass"; }
}

public class Music {
    static void tune(Instrument instrument){
        instrument.play(Note.Do);
    }

    static void tuneAll(Instrument[] orchestra){
        for (Instrument instrument : orchestra){
            tune(instrument);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {new Wind(), new Brass(), new Stringed()};
        tuneAll(orchestra);
    }
}

package com.javarush.task.task19;

/**
 * Created by Alex on 10.02.2020.
 */
public class CardReader implements USB{
    Card card;
    CardReader(Card card){
        this.card = card;
    }

    public static void main(String[] args) {
        Card card = new Card();
        USB cardReader = new CardReader(card);
        cardReader.connectWithUSBCable();
    }

    @Override
    public void connectWithUSBCable() {
        card.sendData();
    }
}

class Card{
    Card(){
    }
    void sendData(){
        System.out.println("Data sent");
    }
}

interface USB{
    void connectWithUSBCable();
}

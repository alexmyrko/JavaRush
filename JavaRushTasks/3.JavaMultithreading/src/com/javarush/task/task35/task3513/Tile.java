package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {
    public int value;

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        this.value = 0;
    }

    public boolean isEmpty(){
        if (value == 0)
            return true;
        else return false;
    }

    public Color getFontColor(){
        if (this.value < 16)
            return new Color(0x776e65);
        else return new Color(0xf9f6f2);


    }

    public Color getTileColor(){
        if (this.value == 0)
            return new Color(0xcdc1b4);
        if (this.value == 2)
            return new Color(0xeee4da);
        if (this.value == 4)
            return new Color(0xede0c8);
        if (this.value == 8)
            return new Color(0xf2b179);
        if (this.value == 16)
            return new Color(0xf59563);
        if (this.value == 32)
            return new Color(0xf67c5f);
        if (this.value == 64)
            return new Color(0xf65e3b);
        if (this.value == 128)
            return new Color(0xedcf72);
        if (value == 256)
            return new Color(0xedcc61);
        if (this.value == 512)
            return new Color(0xedc850);
        if (this.value == 1024)
            return new Color(0xedc53f);
        if (this.value == 2048)
            return new Color(0xedc22e);
        return new Color(0xff0000);
    }



}

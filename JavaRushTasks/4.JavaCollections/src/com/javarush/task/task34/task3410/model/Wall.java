package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject{
    public Wall(int x, int y){
        super(x,y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);

        int x = getX();
        int y = getY();
        int height = getHeight();
        int width = getWidth();

        graphics.fillRect(x - width/2, y - height/2, width, height);
    }
}

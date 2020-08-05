package com.javarush.task.task19;

/**
 * Created by Alex on 03.12.2019.
 */
public class Shape {
    public void draw(){
        System.out.println("draw figure");
    }
    void erase(){
        System.out.println("Erase figure");
    }
}

class Triangle extends Shape{
@Override    public void draw(){
        System.out.println("draw Triangle");
    }
    void erase(){
        System.out.println("Erase Triangle");
    }
}

class Square extends Shape{
@Override    public void draw(){
        System.out.println("draw Square");
    }
    void erase(){
        System.out.println("Erase Square");
    }
}

class ShapeGenerator{
    public Shape next(){
        return new Triangle();
    }
}

class Shapes{
    public static ShapeGenerator gen = new ShapeGenerator();

    public static void main(String[] args) {
        Shape sh = gen.next();
        sh.draw();
    }
}
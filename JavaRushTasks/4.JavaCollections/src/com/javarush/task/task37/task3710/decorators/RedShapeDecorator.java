package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator{
    Shape shape;

    public RedShapeDecorator(Shape shape){
        super(shape);
        this.shape = shape;
    }

    private void setBorderColor(Shape shape){
        System.out.println("Setting the border color for " + shape.getClass().getSimpleName() + " to red.");
    }

    public void draw(){
        setBorderColor(shape);
        shape.draw();
    }
}

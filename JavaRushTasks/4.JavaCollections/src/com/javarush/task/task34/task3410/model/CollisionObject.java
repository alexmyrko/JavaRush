package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{

    public CollisionObject(int x, int y){
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case RIGHT:
                return (y == gameObject.getY() && (x + Model.FIELD_CELL_SIZE == gameObject.getX()));
            case LEFT:
                return (y == gameObject.getY() && (x - Model.FIELD_CELL_SIZE == gameObject.getX()));
            case UP:
                return (x == gameObject.getX() && (y - Model.FIELD_CELL_SIZE == gameObject.getY()));
            case DOWN:
                return (x == gameObject.getX() && (y + Model.FIELD_CELL_SIZE == gameObject.getY()));
            default:
                return false;
        }
    }
}

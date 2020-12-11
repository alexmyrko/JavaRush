package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    GameObjects gameObjects;
    private int currentLevel = 1;

        Path path;
    {
        try {
            path = Paths.get(getClass().getResource("../res/levels.txt").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private LevelLoader levelLoader = new LevelLoader(path);

    public Model() {
    }

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){
        return gameObjects;
    }

    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction){
        if (checkWallCollision(gameObjects.getPlayer(), direction))
            return;
        if (checkBoxCollisionAndMoveIfAvailable(direction))
            return;

        Player player = gameObjects.getPlayer();
        int dX = 0;
        int dY = 0;
        if (direction == Direction.RIGHT)
            dX += FIELD_CELL_SIZE;
        else if (direction == Direction.LEFT)
            dX -= FIELD_CELL_SIZE;
        else if (direction == Direction.UP)
            dY -= FIELD_CELL_SIZE;
        else if (direction == Direction.DOWN)
            dY += FIELD_CELL_SIZE;
        player.move(dX, dY);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction))
                return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction){
        for(Box box : gameObjects.getBoxes()){
            if (gameObjects.getPlayer().isCollision(box, direction)){
                for(Box anotherBox : gameObjects.getBoxes()) {
                    if (!box.equals(anotherBox)) {
                        if (box.isCollision(anotherBox, direction))
                            return true;
                    }
                }
                if (checkWallCollision(box, direction))
                    return true;
                int dX = 0;
                int dY = 0;
                if (direction == Direction.RIGHT)
                    dX += FIELD_CELL_SIZE;
                else if (direction == Direction.LEFT)
                    dX -= FIELD_CELL_SIZE;
                else if (direction == Direction.UP)
                    dY -= FIELD_CELL_SIZE;
                else if (direction == Direction.DOWN)
                    dY += FIELD_CELL_SIZE;
                box.move(dX, dY);
            }
        }
        return false;
    }

    public void checkCompletion(){
        int numberOfHouses = gameObjects.getHomes().size();
        int numberOfHousesWithBoxex = 0;

        for (Home home : gameObjects.getHomes()){
            for (Box box : gameObjects.getBoxes()){
                if (box.getX() == home.getX() && box.getY() == home.getY())
                    numberOfHousesWithBoxex++;
            }
        }

        if (numberOfHousesWithBoxex == numberOfHouses){
            eventListener.levelCompleted(currentLevel);
            System.out.println("Level completed !");
        }
    }
}

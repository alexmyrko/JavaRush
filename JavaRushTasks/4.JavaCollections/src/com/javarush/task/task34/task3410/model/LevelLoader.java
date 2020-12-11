package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels){
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        int loopLevel;
        if (level > 60)
            loopLevel = level % 60;
        else loopLevel = level;
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toString()))) {
            String line = null;
            int currentLevel = 0;
            int y = 0;
            System.out.println("Level: " + level);
            boolean blockIsReading = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Maze:")) {
                    currentLevel = Integer.parseInt(line.split(" ")[1]);
                    continue;
                }
                if (currentLevel == loopLevel){
                    if (line.isEmpty() && !blockIsReading) {
                        blockIsReading = true;
                        y = Model.FIELD_CELL_SIZE / 2;
                        continue;
                    }
                    else if (line.isEmpty() && blockIsReading) {
                        blockIsReading = false;
                    }
                }
                if (blockIsReading){
                    int x = Model.FIELD_CELL_SIZE / 2;
                    for (int i = 0; i < line.length(); i++){
                        switch (line.charAt(i)){
                            case 'X':
                                walls.add(new Wall(x, y));
                                break;
                            case '*':
                                boxes.add(new Box(x, y));
                                break;
                            case '.':
                                homes.add(new Home(x, y));
                                break;
                            case '&':
                                homes.add(new Home(x, y));
                                boxes.add(new Box(x, y));
                                break;
                            case '@':
                                player = new Player(x, y);
                        }
                        x += Model.FIELD_CELL_SIZE;
                    }
                    y += Model.FIELD_CELL_SIZE;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GameObjects(walls, boxes, homes, player);
    }
}

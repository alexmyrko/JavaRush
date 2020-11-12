package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    int score;
    int maxTile;
    Stack<Tile[][]> previousStates = new Stack();
    Stack<Integer> previousScores = new Stack();

    boolean isSaveNeeded = true;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model(){
        resetGameTiles();
        score = 0;
        maxTile = 2;
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> tiles = new ArrayList<>();
        for(int i = 0; i < FIELD_WIDTH; i++ ){
            for(int j = 0; j < FIELD_WIDTH; j++){
                if (gameTiles[i][j].isEmpty()){
                    tiles.add(gameTiles[i][j]);
                }
            }
        }
        return tiles;
    }

    private void addTile(){
        List<Tile> tiles = getEmptyTiles();
        Tile tile;
        if (!tiles.isEmpty()) {
            tile = tiles.get((int) (Math.random() * tiles.size()));
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    public void resetGameTiles(){
        for(int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles){
        int counter = 0;
        int emptyTiles = 0;
        boolean isCompressed = false;
        for(Tile tile : tiles){
            if (tile.isEmpty())
                emptyTiles++;
        }
        while(counter != tiles.length - emptyTiles){
            if (!tiles[counter].isEmpty())
                counter++;
            else{
                for(int i = counter; i < tiles.length - 1; i++){
                    if(tiles[i].isEmpty() && !tiles[i+1].isEmpty()) {
                        Tile temp = tiles[i + 1];
                        tiles[i+1] = tiles[i];
                        tiles[i] = temp;
                        isCompressed = true;
                    }
                }
            }
        }
        return isCompressed;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean isMerged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (!tiles[i].isEmpty() && tiles[i].value == tiles[i+1].value) {
                tiles[i].value = tiles[i + 1].value * 2;
                tiles[i + 1].value = 0;
                score += tiles[i].value;
                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
                isMerged = true;
            }
        }
        return isMerged;
    }

    public void left(){
        if(isSaveNeeded)
            saveState(gameTiles);
        boolean isCompressed = false;
        boolean isMerged = false;
        for(int i = 0; i < gameTiles.length; i++) {
            if (mergeTiles(gameTiles[i]))
                isMerged = true;
            if (compressTiles(gameTiles[i]))
                isCompressed = true;
        }
        if (isCompressed | isMerged)
            addTile();
        isSaveNeeded = true;
    }

    public void up(){
        saveState(gameTiles);
        gameTiles = rotateLeft();
        left();
        gameTiles = rotateLeft();
        gameTiles = rotateLeft();
        gameTiles = rotateLeft();
    }

    public void down(){
        saveState(gameTiles);
        gameTiles = rotateLeft();
        gameTiles = rotateLeft();
        gameTiles = rotateLeft();
        left();
        gameTiles = rotateLeft();
    }

    public void right(){
        saveState(gameTiles);
        gameTiles = rotateLeft();
        gameTiles = rotateLeft();
        left();
        gameTiles = rotateLeft();
        gameTiles = rotateLeft();
    }

    public Tile[][] rotateLeft() {
        Tile[][] rotatedTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rotatedTiles[i][j] = gameTiles[j][FIELD_WIDTH - i - 1];
            }
        }
        return rotatedTiles;
    }

    public Tile[][] getGameTiles(){
        return gameTiles;
    }

    public boolean canMove(){
        if (!getEmptyTiles().isEmpty())
            return true;
        for(int i = 0; i < FIELD_WIDTH; i++){
            for (int j = 0; j < FIELD_WIDTH - 1; j++){
                if (gameTiles[i][j].value == gameTiles[i][j+1].value)
                    return true;
            }
        }
        for(int j = 0; j < FIELD_WIDTH; j++){
            for (int i = 0; i < FIELD_WIDTH - 1; i++){
                if (gameTiles[i][j].value == gameTiles[i+1][j].value)
                    return true;
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles){
        Tile[][] stackTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                stackTile[i][j] = new Tile();
                stackTile[i][j].value = tiles[i][j].value;
            }
        }
        previousStates.push(stackTile);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (!previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
        }
        if (!previousScores.isEmpty()) {
            score = previousScores.pop();
        }
    }

    public void randomMove(){
        int n = (int) ((Math.random()*100) % 4);
        switch (n){
            case 0: left();
                    break;
            case 1: right();
                    break;
            case 2: up();
                    break;
            case 3: down();
                    break;
        }
    }

    public boolean hasBoardChanged(){
        int originValues = 0;
        int stackValues = 0;
        Tile[][] stackTile = previousStates.peek();
        for(int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if(!gameTiles[i][j].isEmpty())
                    originValues += gameTiles[i][j].value;
                if(!stackTile[i][j].isEmpty())
                    stackValues += stackTile[i][j].value;
            }
        }
        if (originValues != stackValues)
            return true;
        else return false;
    }

    MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged())
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else{
            rollback();
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        queue.peek().getMove().move();
    }
}
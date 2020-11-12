package com.javarush.task.test.task3513;

import com.javarush.task.task35.task3513.Model;
import com.javarush.task.task35.task3513.Tile;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {



 /*   @Test
    void compressTiles() {
        Model model = new Model();
        Tile[] tilesOrigin = new Tile[4];
        Tile[] tilesResult = new Tile[4];

        for(int i = 0; i < tilesResult.length; i++){
            tilesOrigin[i] = new Tile();
            tilesResult[i] = new Tile();
        }
        tilesOrigin[0].value = 0;
        tilesOrigin[1].value = 0;
        tilesOrigin[2].value = 0;
        tilesOrigin[3].value = 2;

        tilesResult[0].value = 2;
        tilesResult[1].value = 0;
        tilesResult[2].value = 0;
        tilesResult[3].value = 0;
        model.compressTiles(tilesOrigin);
        for(int i = 0; i < tilesOrigin.length; i++) {
//            assertEquals(tilesResult[i].value, tilesOrigin[i].value);
            System.out.println(tilesOrigin[i].value + " " + tilesResult[i].value);
        }
    }*/

/*
..    @Test void mergeTiles(){
        Model model = new Model();
        Tile[] tilesOrigin = new Tile[4];
        Tile[] tilesResult = new Tile[4];

        for(int i = 0; i < tilesResult.length; i++){
            tilesOrigin[i] = new Tile();
            tilesResult[i] = new Tile();
        }
        tilesOrigin[0].value = 4;
        tilesOrigin[1].value = 4;
        tilesOrigin[2].value = 4;
        tilesOrigin[3].value = 4;

        tilesResult[0].value = 8;
        tilesResult[1].value = 8;
        tilesResult[2].value = 0;
        tilesResult[3].value = 0;
        model.mergeTiles(tilesOrigin);
        for(int i = 0; i < tilesOrigin.length; i++)
            assertEquals(tilesResult[i].value, tilesOrigin[i].value);
        assertEquals(16, model.score);
        assertEquals(8, model.maxTile);
    }
*/

}
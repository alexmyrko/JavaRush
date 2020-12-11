package com.javarush.task.task39.task3905;

import java.util.Random;

import static com.javarush.task.task39.task3905.Color.BLUE;
import static com.javarush.task.task39.task3905.Color.ORANGE;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        Color[][] colors = new Color[5][5];
        for (int i = 0; i < colors.length - 1; i++) {
            for (int j = 0; j < colors[0].length; j++) {
                colors[i][j] = BLUE;
            }
        }

        for (int i = 0; i < colors[0].length; i++) {
            colors[4][i] = Color.GREEN;
        }

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[0].length; j++) {
                System.out.print(colors[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(new PhotoPaint().paintFill(colors, 2, 4, Color.RED));
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[0].length; j++) {
                System.out.print(colors[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
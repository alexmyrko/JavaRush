package com.javarush.task.task20.task2026;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        byte[][] a3 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 5");
    }

    public static int getRectangleCount(byte[][] a) {
        int size = a.length;
        int count = 0;
        int x1, x2, y1, y2;

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (a[i][j] == 1) {
                    x1 = x2 = j;
                    y1 = y2 = i;
                    while(true){
                        while(!(x2 + 1 == size || a[y2][x2 + 1] == 0)){
                            x2++;
                        }
                         if (y2 + 1 == size || a[y2+1][x2] == 0)
                             break;
                         else
                             y2++;
                    }
                    for (int k = y1; k <= y2; k++)
                        for (int l = x1; l <= x2; l++)
                            a[k][l] = 0;

                    count++;
                    }
                }
            }
        return count;
        }
    }

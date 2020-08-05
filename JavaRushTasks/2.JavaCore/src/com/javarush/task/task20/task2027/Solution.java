package com.javarush.task.task20.task2027;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list  = detectAllWords(crossword, "home", "same");
        for (Word word : list)
            System.out.println(word.toString());
    }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        int xMax = crossword[0].length - 1;
        int yMax = crossword.length - 1;
        Word found;
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
        char[] word;

        for (String s : words) {
            word = s.toCharArray();
            System.out.println(word);
            for (int y = 0; y <= yMax; y++) {
                for (int x = 0; x <= xMax; x++) {
                    if (word[0] == crossword[y][x]) {
                        for (int i = 0; i < dx.length; i++) {
                            found = search(x, y, dx[i], dy[i], crossword, word);
                            if (found != null)
                                list.add(found);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static Word search(int x, int y, int dx, int dy, int[][] crossword, char[] word) {
        boolean theSame = false;
        Word found;
        int thisX = x;
        int thisY = y;

        try {
            for (int i = 0; i < word.length; i++) {
                if (crossword[thisY][thisX] == word[i]) {
                    theSame = true;
                    if (i != word.length - 1) {
                        thisY = thisY + dy;
                        thisX = thisX + dx;
                    }
                }
                else {
                    theSame = false;
                    break;
                }
            }
            if (theSame){
                found = new Word(String.valueOf(word));
                found.setStartPoint(x, y);
                found.setEndPoint(thisX, thisY);
            } else
                found = null;
        } catch(Exception IndexOutOfBoundsException){
            found = null;
        }
        return found;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
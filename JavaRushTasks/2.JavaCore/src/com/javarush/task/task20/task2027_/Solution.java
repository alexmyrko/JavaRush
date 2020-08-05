package com.javarush.task.task20.task2027_;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
//        int[][] crossword2 = new int[][]{
                {'r', 'm', 'a', 'r', 'r', 'e'},
                {'m', 'e', 'a', 'e', 'e', 'm'},
                {'s', 'a', 'm', 'e', 's', 'o'},
                {'m', 'o', 'p', 'o', 'o', 'h'},
                {'h', 'r', 'e', 'm', 'h', 'h'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same", "homer");
        for (Word word : list){
            System.out.println(word.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int width = crossword[0].length;
        int height = crossword.length;
        int k = 0;
        int l = 0;
        List<Word> list = new ArrayList<>();
        for (String word : words) {
            int wordLength = word.length();
            char[] reverse = new char[wordLength];
            char[] sample = new char[wordLength];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    System.out.println(i + " : " + j);

                    if (j + wordLength <= width) {              // 1 horizontal ahead
                        k = j;
                        while (k < (j + wordLength)) {
                            sample[k - j] = (char) crossword[i][k];
                            k++;
                        }
                        String s = String.valueOf(sample);
                        System.out.println(s);
                        if (word.equals(s)) {
                            Word found = new Word(s);
                            found.setStartPoint(j, i);
                            found.setEndPoint(j + wordLength - 1, i);
                            list.add(found);
                        }
                        for (int m = 0; m < wordLength ; m++) {
                            reverse[m] = sample[wordLength - m - 1];
                        }
                        s = String.valueOf(reverse);
                        System.out.println(s);
                        if (word.equals(s)) {
                            Word found = new Word(s);
                            found.setStartPoint(j + wordLength - 1, i);
                            found.setEndPoint(j, i);
                            list.add(found);
                        }
                    }

                    if (j + wordLength <= width && i - wordLength  >= -1 ) {   // 2 diagonal right up
                        k = j;
                        l = i;
                        while (k < (j + wordLength) && j - wordLength <= l) {
                            sample[k - j] = (char) crossword[l][k];
                            l--;
                            k++;
                        }
                        String s = String.valueOf(sample);
                        System.out.println(s);
                        if (word.equals(s)) {
                            Word found = new Word(s);
                            found.setStartPoint(j, i);
                            found.setEndPoint(j + wordLength - 1, i - wordLength + 1);
                            list.add(found);
                        }
                        for (int m = 0; m < wordLength ; m++) {
                            reverse[m] = sample[wordLength - m - 1];
                        }
                        s = String.valueOf(reverse);
                        System.out.println(s);
                        if (word.equals(s)) {
                            Word found = new Word(s);
                            found.setStartPoint(j + wordLength, i - wordLength + 1);
                            found.setEndPoint(j, i);
                            list.add(found);
                        }
                    }

                    if (j + wordLength <= width && i + wordLength <= height) {   // 3 diagonal right down
                        k = j;
                        l = i;
                        while (k < (j + wordLength) && l < i + wordLength ) {
                            sample[k - j] = (char) crossword[l][k];
                            l++;
                            k++;
                        }
                        String s = String.valueOf(sample);
                        System.out.println(s);
                        if (word.equals(s)) {
                            Word found = new Word(s);
                            found.setStartPoint(j, i);
                            found.setEndPoint(j + wordLength - 1, i + wordLength - 1);
                            list.add(found);
                        }
                        for (int m = 0; m < wordLength ; m++) {
                            reverse[m] = sample[wordLength - m - 1];
                        }
                        s = String.valueOf(reverse);
                        System.out.println(s);
                        if (word.equals(s)) {
                            Word found = new Word(s);
                            found.setStartPoint(j + wordLength - 1, i + wordLength - 1);
                            found.setEndPoint(j, i);
                            list.add(found);
                        }
                    }

                    if (i + wordLength <= height) {                 // 4 vertical down
                        l = i;
                        while (l < i + wordLength ) {
                            sample[l - i] = (char) crossword[l][j];
                            l++;
                        }
                        String s = String.valueOf(sample);
                        System.out.println(s);
                        if (word.equals(s)) {
                            Word found = new Word(s);
                            found.setStartPoint(j, i);
                            found.setEndPoint(j, i + wordLength - 1);
                            list.add(found);
                        }
                        for (int m = 0; m < wordLength ; m++) {
                            reverse[m] = sample[wordLength - m - 1];
                        }
                        s = String.valueOf(reverse);
                        System.out.println(s);
                        if (word.equals(s)) {
                            Word found = new Word(s);
                            found.setStartPoint(j, i + wordLength - 1);
                            found.setEndPoint(j, i);
                            list.add(found);
                        }
                    }
                }
            }
        }
        return list;
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

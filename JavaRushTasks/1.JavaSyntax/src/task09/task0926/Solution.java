package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/*
 1. Программа не должна считывать данные с клавиатуры.
 2. Метод createList должен объявлять и инициализировать переменную типа ArrayList.
 3. Метод createList должен возвращать созданный список.
 4. Метод createList должен добавлять в список 5 элементов.
 5. Каждый элемент в списке должен быть массивом чисел. Длина первого должна быть 5 элементов, второго - 2, следующих - 4, 7, 0 соответственно.
 6. Программа должна выводить на экран элементы всех массивов из списка. Каждый элемент с новой строки.
 */
public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[] {3, -5, 0, 4, 7});
        list.add(new int[] {2, -6});
        list.add(new int[] {-3, 3, 11, 4});
        list.add(new int[] {8, 5, 0, 1, 17, 15, 3});
        list.add(new int[] {});
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}

package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
/*
        Integer[] array = {2,7,8,3,5,12,10,4};
        Solution solution = new Solution();
        solution.sort(array);
        System.out.println("-----------------");
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int mediana;
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
/*        for (Integer n: list
             ) {
            System.out.println(n);
        }*/
        if (array.length % 2 != 0)
            mediana = array[array.length / 2];
        else mediana = (array[array.length/2 - 1] + array[array.length/2]) / 2;
//        System.out.println(mediana);
        Comparator<Integer> comparator = Comparator.comparingInt(o -> Math.abs(mediana - o));
        Collections.sort(list, comparator);
        return array;
    }
}

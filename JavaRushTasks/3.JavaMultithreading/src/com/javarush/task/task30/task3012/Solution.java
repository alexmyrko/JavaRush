package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(59);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        String res = new BigInteger(String.valueOf(number)).toString(3);
        List<Integer> list = new ArrayList<>();
        for (int i = res.length()-1; i >= 0 ; i--){
            list.add(Integer.parseInt(String.valueOf(res.charAt(i))));
        }
        int div = 0;
        for (int i = 0; i<res.length(); i++){
            if (list.get(i) == 2){
                list.set(i, -1 + div);
                div = 1;
            }
            else {
                if (div == 1 && list.get(i) == 1){
                    list.set(i, -1);
                    div = 1;
                }
                else if (div == 1 && list.get(i) == 0) {
                    list.set(i, 1);
                    div = 0;
                }
                }
        }
        if (list.get(list.size()-1) == -1)
            list.add(1);

        System.out.print(number + " =");
        for(int i =0; i < list.size(); i++){
            int n = Math.abs(list.get(i)*(int)Math.pow(3,i));
            if (list.get(i) < 0)
                System.out.print(" - " + n);
            else if (list.get(i) > 0) System.out.print(" + " + n);

        }
        System.out.println(new BigInteger(res).toString(16));

    }
}
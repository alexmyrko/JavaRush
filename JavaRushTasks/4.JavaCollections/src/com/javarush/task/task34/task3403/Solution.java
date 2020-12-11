package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        if (n <= 1)
            return;
        if (isSimple(n))
            System.out.println(n);
        for (int i = 2; i < n; i++) {
            if ((n % i) == 0) {
                    System.out.println(i);
                recurse(n / i);
                break;
            }
        }

    }

    boolean isSimple(int n) {
        boolean isSimple = true;
        if (n > 1) {
            for (int i = 2; i < n; i++)
                if ((n % i) == 0)
                    isSimple = false;
        }
        return isSimple;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
    }
}

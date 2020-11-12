package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == this)
            return true;
        if (!(n instanceof Solution))
            return false;

        Solution obj = (Solution) n;

        if (first != null ? !first.equals(obj.first) : obj.first != null) return false;
        else return last != null ? last.equals(obj.last) : obj.last == null;
    }


    public int hashCode() {
//            return 31 * first.hashCode() + last.hashCode();
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
/*
        s.add(new Solution(null , null));
        System.out.println(s.contains(new Solution(null, null)));*/
    }
}

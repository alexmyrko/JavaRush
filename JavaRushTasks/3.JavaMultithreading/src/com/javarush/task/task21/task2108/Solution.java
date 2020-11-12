
package com.javarush.task.task21.task2108;


/*
Клонирование растений
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        public Object clone() throws CloneNotSupportedException{
            String[] branches2 = new String[branches.length];
            for (int i = 0; i < branches.length; i++){
                branches2[i] = branches[i];
                System.out.println(branches[i]);
            }
            return new Tree(super.name, branches2);

        }

        public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof Tree)) return false;

            Tree tree = (Tree) o;
            for (int i = 0; i < branches.length; i++){
                if (branches[i] != null ? !branches[i].equals(tree.branches[i]) : tree.branches[i] != null) return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(branches);
        }
    }
}
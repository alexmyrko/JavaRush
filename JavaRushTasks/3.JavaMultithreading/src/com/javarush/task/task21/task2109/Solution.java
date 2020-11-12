package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Object clone() throws CloneNotSupportedException{
            throw new CloneNotSupportedException();
//            return null;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public Object clone(){
            return new C(this.getI(), this.getJ(), this.getName());
        }
    }

    public static void main(String[] args) {
        A a = new A(2,3);
        B b = new B(4, 5, "B class");
        C c = new C(6,7, "C class");
        System.out.println(a.i + " " + a.j);
        System.out.println(b.getI() + "  " + b.getJ() + "  " + b.name);
        System.out.println(c.getI() + "  " + c.getJ());
        C clone2 = (C) c.clone();
        System.out.println(clone2.getI() + ":" + clone2.getJ() + ":" + clone2.getName());
        try {
            B clone = (B) b.clone();
        } catch (CloneNotSupportedException e){
            System.out.println("Clone exception");
        }
    }
}

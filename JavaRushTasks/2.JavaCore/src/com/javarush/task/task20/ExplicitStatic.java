package com.javarush.task.task20;

/**
 * Created by Alex on 01.12.2019.
 */

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }
    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cupl;
    static Cup cup2;

    static {
    cupl = new Cup(1);
    cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}

public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
//        Cups.cupl.f(99); // (1)
    }
    static Cups cupsl = new Cups(); // (2)
//     static Cups cups2 = new Cups(); // (2)
}


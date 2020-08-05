package com.javarush.task.task20;

/**
 * Created by Alex on 01.12.2019.
 */
class Spoon {
    static String s = "spoooon";
    Spoon(int marker) {
        System.out.println("Spoon(" + marker + ")");
    }
    static {
        String s2 = "sssspn";
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
        System.out.println(s);
    }

}

class Spoons {
    static Spoon spoon1;
//    static Spoon spoon2;

    static {
        spoon1 = new Spoon(1);
    }

    Spoons() {
        System.out.println("Cups()");
    }
}
public class ExplicitStatic2 {
    public static void main(String[] args) {
        System.out.println("Inside main()");
//        Cups.cupl.f(99); // (1)
    }
    static Cups cupsl = new Cups(); // (2)
//     static Cups cups2 = new Cups(); // (2)
}
package com.javarush.task.task19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 22.03.2019.
 */
    class Homer {
        char doh(char с) {
            System.out.println("doh(char)");
            return 'd';
        }
    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
        }
    }
    class Milhouse {}

//    class Bart extends Homer {
//            void doh(Milhouse m) {
//                System.out.println("doh(Milhouse)");
//            }
//        }

        class Lisa extends Homer{
            void doh(Milhouse m){
                System.out.println("doh(Milhouse)");
            }
        }

    public class test {
        public static void main(String[] args) {
            Lisa b = new Lisa();
            b.doh(1);
            b.doh('x');
            b.doh(1.0f);
            b.doh(new Milhouse());
        }
    }

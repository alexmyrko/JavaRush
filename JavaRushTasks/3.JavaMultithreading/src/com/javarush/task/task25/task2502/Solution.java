package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            String wheelNames[] = loadWheelNamesFromDB();
            if (wheelNames.length != 4)
                throw new IllegalArgumentException();
            for (int i = 0; i < wheelNames.length; i++) {
                if (Wheel.valueOf(wheelNames[i]).ordinal() < 0 || Wheel.valueOf(wheelNames[i]).ordinal() >= 4)
                    throw new IllegalArgumentException();
            }
            wheels = new ArrayList<>();
            for (int i = 0; i < wheelNames.length; i++) {
                wheels.add(Wheel.valueOf(wheelNames[i]));
//                System.out.println(Wheel.valueOf(wheelNames[i]).ordinal());
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        for (Wheel wheel : car.wheels){
            System.out.println(wheel);
        }
    }
}

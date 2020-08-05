package com.javarush.task.task13.task1301;

/**
 * Created by alex on 19.03.2018.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Drink {
        void askMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcohol extends Drink {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public static class Beer implements Alcohol{


        public void askMore(String message){
            System.out.println(message);
        }

        public void sayThankYou(){
            System.out.println("Thank You !");
        }

        public boolean isReadyToGoHome(){
            if (READY_TO_GO_HOME)
                return true;
            else
                return false;
        }

      public void sleepOnTheFloor(){
            System.out.println("Sleep on the floor");
        }
    }
}

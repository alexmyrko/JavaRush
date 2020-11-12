package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String s = null;
        do{
            try {
                s = reader.readLine();
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        while(s == null);
        return s;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> dishes = new ArrayList<>();
        Dish.allDishesToString();
        String dish = "";
        while (!dish.equals("exit")){
            writeMessage("Choose your dish: ");
            dish = readString();
            switch (dish){
                case "Fish":
                    dishes.add(Dish.Fish);
                    break;
                case "Steak":
                    dishes.add(Dish.Steak);
                    break;
                case "Soup":
                    dishes.add(Dish.Soup);
                    break;
                case "Juice":
                    dishes.add(Dish.Juice);
                    break;
                case "Water":
                    dishes.add(Dish.Water);
                    break;
                case "exit": break;
                default: writeMessage("Dish does not exist. Please try again.");
            }
        }
        return dishes;
    }
}

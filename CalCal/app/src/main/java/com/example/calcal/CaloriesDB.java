package com.example.calcal;

import android.provider.ContactsContract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CaloriesDB
{
    private static Map<String, Integer> fruitCalMap = null;
    private static Map<String, Integer> foodCalMap = null;
    private static Map<String, Integer> drinkcalMap = null;


    public static void loadFruitMap() throws Exception {
        if (fruitCalMap == null){
            fruitCalMap = new TreeMap<>();
            File file = new File("fruitCal.txt");
            Scanner console = new Scanner(file);
            while(console.hasNext()) {
                String fruitName = console.nextLine();
                int fruitCal = console.nextInt();
                fruitCalMap.put(fruitName, fruitCal);
            }
        }
    }

    public static void loadFoodMap() throws Exception{
        if (foodCalMap == null){
            foodCalMap = new TreeMap<>();
            File file = new File("foodCal.txt");
            Scanner console = new Scanner(file);
            while(console.hasNext()) {
                String foodName = console.nextLine();
                int foodCal = console.nextInt();
                fruitCalMap.put(foodName, foodCal);
            }
        }
   }

   public static Map<String,Integer> getDrinkCalMap(){

        return drinkcalMap;
   }

    public static Map<String,Integer> getFruitCalMap(){

        return fruitCalMap;
    }

    public static Map<String,Integer> getFoodCalMap(){

        return foodCalMap;
    }
}

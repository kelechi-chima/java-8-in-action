package com.kchima;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamsInAction {

    static final List<Dish> menu = Arrays.asList(
            new Dish("Chicken Korma", 1200),
            new Dish("Lamb Tikka", 1150),
            new Dish("Chicken Tikka", 1250),
            new Dish("Veggie Burger", 950),
            new Dish("Moroccan special couscous", 900),
            new Dish("Shepherds Pie", 1500),
            new Dish("Fish and Chips", 1650)
    );

    public static void main(String[] args) {
        //List<String> lowCalorieDishNames = listLowCalorieDishNamesJava7();
        //System.out.println(lowCalorieDishNames);

        List<String> lowCalorieDishNames = listLowCalorieDishNamesJava8();
        System.out.println(lowCalorieDishNames);
    }

    private static List<String> listLowCalorieDishNamesJava7() {
        List<Dish> lowCalorieDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 1000) {
                lowCalorieDishes.add(dish);
            }
        }

        Collections.sort(lowCalorieDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        List<String> lowCalorieDishNames = new ArrayList<>(lowCalorieDishes.size());
        for (Dish lowCalorieDish : lowCalorieDishes) {
            lowCalorieDishNames.add(lowCalorieDish.getName());
        }
        return lowCalorieDishNames;
    }

    private static List<String> listLowCalorieDishNamesJava8() {
        return menu.stream()
                .filter(d -> d.getCalories() < 1000)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}

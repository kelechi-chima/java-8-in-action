package com.kchima;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class FilterInAction {

    static final List<Apple> inventory = Arrays.asList(new Apple("green", 55), new Apple("red", 75), new Apple("purple", 100), new Apple("yellow", 32));
    
    static final List<Transaction> transactions = Arrays.asList(
        new Transaction(Currency.getInstance(Locale.UK), BigDecimal.valueOf(1000.00)),
        new Transaction(Currency.getInstance(Locale.UK), BigDecimal.TEN),
        new Transaction(Currency.getInstance(Locale.UK), BigDecimal.valueOf(55.00)));
    
    public static void main(String[] args) {
        // filter with method references
        System.out.println(filterApples(inventory, FilterInAction::isGreenApple));
        System.out.println(filterApples(inventory, FilterInAction::isHeavyApple));
        
        // filter with lambdas
        System.out.println(filterApples(inventory, (Apple a) -> "green".equals(a.colour)));
        System.out.println(filterApples(inventory, (Apple a) -> a.weight > 70));
    }
    
    static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.colour);
    }
    
    static boolean isHeavyApple(Apple apple) {
        return apple.weight > 70;
    }
    
    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<Apple>();
        
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        
        return result;
    }
}

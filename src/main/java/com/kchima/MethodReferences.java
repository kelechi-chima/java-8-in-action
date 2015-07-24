package com.kchima;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferences {

    public static void main(String[] args) {
        // (String s) -> Integer.parseInt(s)
        Function<String, Integer> f = Integer::parseInt;
        System.out.println(f.apply("12"));

        // (list, s) -> list.contains(s)
        BiPredicate<List<String>, String> contains = List::contains;
        List<String> countries = Arrays.asList("Jamaica", "Nigeria", "Kenya", "Australia");
        System.out.println(contains.test(countries, "Kenya"));

        // (colour, weight) -> new Apple(colour, weight)
        BiFunction<String, Integer, Apple> appleProducer = Apple::new;
        System.out.println(appleProducer.apply("Green", 124));
    }

}

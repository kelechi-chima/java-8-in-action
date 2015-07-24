package com.kchima;

import java.util.Objects;

public class Dish {

    private final String name;
    private final int calories;

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(calories, dish.calories) &&
                Objects.equals(name, dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories);
    }
}

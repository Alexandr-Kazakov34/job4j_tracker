package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    String name = "extra tomato";

    @Override
    public String name() {
        return super.name() + " + " + name;
    }
}

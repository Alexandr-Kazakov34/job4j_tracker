package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    static final String NAME = "extra cheese";

    @Override
    public String name() {
        return super.name() + " + " + NAME;
    }
}

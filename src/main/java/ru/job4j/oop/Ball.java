package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("съеден");
        } else {
            System.out.println("сбежал");
        }
    }
}

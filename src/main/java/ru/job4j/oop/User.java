package ru.job4j.oop;

public class User {
    private String name; // это поля обьекта т.к  объявляется в области класса
    private int age;

    public boolean canDrive() {
        boolean can = false; // это локальная переменная объявляется внутри метода
        if (age >= 18) {
            can = true;
        }
        return can;
    }
}

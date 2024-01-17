package ru.job4j.oop;

public class User {
    /*
   name, age это поля обьекта т.к  объявляется в области класса
     */
    private String name;
    private int age;

    public boolean canDrive() {
        /*
       can это локальная переменная объявляется внутри метода
         */
        boolean can = false;
        if (age >= 18) {
            can = true;
        }
        return can;
    }
}

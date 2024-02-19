package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    private String message;

    public ElementNotFoundException(String message) {
        this.message = message;
    }
}
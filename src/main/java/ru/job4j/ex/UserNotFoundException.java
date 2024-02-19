package ru.job4j.ex;

public class UserNotFoundException extends Exception {
    private String message = "User is not find";

    @Override
    public String getMessage() {
        return message;
    }
}

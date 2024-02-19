package ru.job4j.ex;

public class UserInvalidException extends UserNotFoundException {
    private String message = "User is not valid";

    @Override
    public String getMessage() {
        return message;
    }
}

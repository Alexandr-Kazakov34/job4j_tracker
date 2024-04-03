package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банка
 *
 * @author Alexandr
 * @version 1.0
 */
public class User {
    /**
     * Имеет поля String passport и String username
     */
    private String passport;
    private String username;

    /**
     * При создании объекта инициализируется 2мя приватными полями String
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод
     *
     * @return passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает на вход
     *
     * @param passport и изменяет его
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает на вход
     *
     * @param username и изменяет его
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод сравнивает объекты User по полю passport
     *
     * @param o если равен null или не является User то
     * @return false иначе true
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод сравнивает объекты User по hashcode
     *
     * @return hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}

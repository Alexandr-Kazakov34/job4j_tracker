package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает счет в банке
 *
 * @author Alexandr
 * @version 1.0
 */
public class Account {
    /**
     * Имеет поля String requisite и double balance
     */
    private String requisite;
    private double balance;

    /**
     * При создании объекта инициализируется 2мя приватными полями String, double
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод
     *
     * @return requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход
     *
     * @param requisite и изменяет его
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход
     *
     * @param balance и изменяет его
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод сравнивает объекты Account по requisite
     *
     * @param o если равен null или не является Account то
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод сравнивает объекты Account по hashcode
     *
     * @return hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}

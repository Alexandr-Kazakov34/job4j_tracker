package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковские операции
 *
 * @author Alexandr
 * @version 1.0
 */
public class BankService {
    /**
     * В Map хранятся пользователи со своими счетами в банке
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет
     *
     * @param user пользователя и к нему пустой список возможных счетов в виде ArrayList
     */
    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    /**
     * Метод принимает на вход
     *
     * @param passport и если в списке users есть пользователь с таким параметром то удаляет его
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход
     *
     * @param passport с помощью метода findByPassport находит пользователя
     * @param account  если пользователь существует с помощью метода getAccounts
     *                 получаем список всех его счетов и если в списке нет account, то добавляем
     */
    public void addAccount(String passport, Account account) {
        User byPassport = findByPassport(passport);
        if (byPassport != null) {
            List<Account> accounts = getAccounts(byPassport);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход
     *
     * @param passport и по нему ищет пользователя в списке users
     * @return пользователя если он есть
     */
    public User findByPassport(String passport) {
        for (User s : users.keySet()) {
            if (s.getPassport().equals(passport)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход
     *
     * @param passport  с помощью метода findByPassport ищет пользователя
     *                  если он существует с помощью метода getAccounts получаем список его счетов
     * @param requisite если хранится в списке счетов то
     * @return этот счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User byPassport = findByPassport(passport);
        if (byPassport != null) {
            List<Account> accounts = getAccounts(byPassport);
            for (Account a : accounts) {
                if (a.getRequisite().equals(requisite)) {
                    return a;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счета на другой, если сумма перевода
     * не превышает имеющейся и принимает на вход
     *
     * @param sourcePassport       пользователь, который делает перевод
     * @param sourceRequisite      счет пользователя который делает перевод
     * @param destinationPassport  пользователь, который получает перевод
     * @param destinationRequisite счет пользователя который получает перевод
     * @param amount               сумма перевода
     * @return true если перевод прошел успешно иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            result = true;
        }

        return result;
    }

    /**
     * Метод принимает на вход
     *
     * @param user пользователя
     * @return все его счета
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

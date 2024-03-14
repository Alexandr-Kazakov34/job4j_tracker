package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void deleteUser(String passport) {
        User byPassport = findByPassport(passport);
        users.remove(byPassport);
    }

    public void addAccount(String passport, Account account) {
        User byPassport = findByPassport(passport);
        List<Account> accounts = getAccounts(byPassport);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User s : users.keySet()) {
            if (s.getPassport().equals(passport)) {
                return s;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User byPassport = findByPassport(passport);
        List<Account> accounts = getAccounts(byPassport);
        if (byPassport != null) {
            for (Account a : accounts) {
                if (a.getRequisite().equals(requisite)) {
                    return a;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

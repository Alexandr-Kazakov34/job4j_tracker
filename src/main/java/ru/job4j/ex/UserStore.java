package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() <= 3) {
            throw new UserInvalidException();
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", false)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        }
    }
}

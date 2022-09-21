package ru.job4j.ex;

public class UserStore {
    private static int i;

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (i = 0; i < users.length; i++) {
            if (users[i].getUsername() == login) {
                return users[i];
            } else {
                throw new UserNotFoundException("Пользователь не найден");
            }
        }
        return users[i];
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ea) {
            ea.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
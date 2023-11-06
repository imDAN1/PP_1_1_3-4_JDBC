package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    private final static UserService UserService = new UserServiceImpl();
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService.createUsersTable();
        UserService.saveUser("Dima", "Nozdrin", (byte) 23);
        UserService.saveUser("Katya", "Nozdrina", (byte) 16);
        UserService.saveUser("Ilya", "Firsov", (byte) 24);
        UserService.saveUser("Masha", "Ivanova", (byte) 22);
        UserService.removeUserById(4);
        UserService.getAllUsers();
        UserService.cleanUsersTable();
        UserService.dropUsersTable();
        Util.closeSessionFactory();
    }
}

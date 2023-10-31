package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util util = new Util();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Dima", "Nozdrin", (byte) 23);
        userDao.saveUser("Katya", "Nozdrina", (byte) 16);
        userDao.saveUser("Ilya", "Firsov", (byte) 24);
        userDao.saveUser("Masha", "Ivanova", (byte) 22);
        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
        util.closeConnection();
    }
}

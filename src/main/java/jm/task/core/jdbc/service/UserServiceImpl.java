package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao u1 = new UserDaoHibernateImpl();
    public void createUsersTable() {
        u1.createUsersTable();
    }

    public void dropUsersTable() {
        u1.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        u1.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        u1.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return u1.getAllUsers();
    }

    public void cleanUsersTable() {
        u1.cleanUsersTable();
    }
}

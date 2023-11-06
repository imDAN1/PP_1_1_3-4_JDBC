//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import java.util.List;
//
//public class UserDaoHibernateImpl implements UserDao {
//    public UserDaoHibernateImpl() {
//
//    }
//    private static final SessionFactory sessionFactory = Util.getSessionFactory();
//
//
//    @Override
//    public void createUsersTable() {
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (`id` BIGINT NOT NULL AUTO_INCREMENT," +
//                    "`Name` VARCHAR(45) NOT NULL,`LastName` VARCHAR(45) NOT NULL," +
//                    "`Age` TINYINT NOT NULL, PRIMARY KEY (`id`));").addEntity(User.class).executeUpdate();
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void dropUsersTable() {
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//            String sql = "DROP TABLE IF EXISTS users";
//            session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        User u1 = new User(name, lastName, age);
//        Transaction transaction = null;
//        try (Session session = sessionFactory.getCurrentSession()) {
//            transaction = session.beginTransaction();
//            session.save(u1);
//            transaction.commit();
//            System.out.println("User c именем - " + u1.getName() + " добавлен в базу данных");
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//            User u1 = session.get(User.class, id);
//            session.delete(u1);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        List<User> allUsers;
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//            allUsers = session.createQuery("from User", User.class).list();
//            System.out.println(allUsers);
//            session.getTransaction().commit();
//        }
//        return allUsers;
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.getCurrentSession()) {
//            transaction = session.beginTransaction();
//            session.createQuery("delete User").executeUpdate();
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw new RuntimeException(e);
//        }
//    }
//}

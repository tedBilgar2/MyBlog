package system.repositories;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.model.User;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    private static final Logger logger = Logger.getLogger(User.class);

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        logger.info("User "+user.getEmail()+ " was successfully added");
    }

    @Transactional
    public User loadUserById(String id) {
        logger.info("Load user by id");
        return (User) sessionFactory.getCurrentSession().createQuery("from User where id = :idParam")
                .setParameter("idParam",id)
                .uniqueResult();
    }

    @Transactional
    public List<User> loadAllUser() {
        logger.info("Load all users");
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        logger.info("User " + user.getEmail() + " was successfully updated");
    }

    @Transactional
    public void deleteUserById(String id) {
        User user = this.loadUserById(id);
        sessionFactory.getCurrentSession().delete(user);
        logger.info("User " + user.getEmail()+" was successfully deleted");
    }
}

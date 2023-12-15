package ru.safin.pp3_1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.safin.pp3_1.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
         this.entityManager = entityManager;
    }

    @Override
    public void createUser(User user) {
            entityManager.persist(user);
    }

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void deleteUser(User user) {
        User userForDetection = entityManager.find(User.class, user.getId());
        if (userForDetection != null) {
            entityManager.remove(userForDetection);
        }
    }

    @Override
    public User getUserForId(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

}
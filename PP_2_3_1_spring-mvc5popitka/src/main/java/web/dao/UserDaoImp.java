package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
         this.entityManager = entityManager;
    }

    @Override
    public void createOrUpdateUser(User user) {
//        if (entityManager.find(User.class,user.getId()) != null){
//            entityManager.merge(entityManager.find(User.class,user.getId()));
//        } else {
            entityManager.merge(user);
//        }
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

//    @Override
//    public void updateUser(Integer id, User user) {
//        entityManager.merge(user);
//    }

}
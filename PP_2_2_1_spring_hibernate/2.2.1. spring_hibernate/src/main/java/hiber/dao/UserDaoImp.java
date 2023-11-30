package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserWitchModelandSeries(String model, Integer series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("SELECT user" +
                " FROM User user " +
                "join user.car cars " +
                "where cars.model = :model " +
                "AND cars.series = :series", User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return (User) query.getSingleResult();
    }

}
package ru.safin.pp3_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.safin.pp3_1.dao.UserDao;
import ru.safin.pp3_1.model.User;

import java.util.List;


@Transactional(readOnly = true)
@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUsersList();
    }

    @Override
    public User getUserForId(int id) {
        return userDao.getUserForId(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }
}
package ru.safin.pp3_1.service;


import ru.safin.pp3_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    User getUserForId(int id);

    void updateUser(User user);

    void deleteUser(User user);
    void createUser(User user);
}
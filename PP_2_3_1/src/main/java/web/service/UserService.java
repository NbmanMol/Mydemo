package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    List<User> getFixedUserList(Integer count);

    User getUserForId(int id);

    void updateUser(User user);

    void deleteUser(User user);
    void createUser(User user);
}
package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    List<User> getFixedUserList(Integer count);

    User getUserForId(int id);

//    void updateUser(Integer id, User user);

    void deleteUser(User user);
    void createOrUpdateUser(User user);
}
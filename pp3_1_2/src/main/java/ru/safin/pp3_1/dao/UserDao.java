package ru.safin.pp3_1.dao;




import ru.safin.pp3_1.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    List<User> getUsersList();
    void deleteUser(User user);

    User getUserForId(int id);

    void updateUser(User user );
}
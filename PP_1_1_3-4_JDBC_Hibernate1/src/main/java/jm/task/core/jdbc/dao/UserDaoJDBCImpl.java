package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    private Statement createStatament() {     //Для того чтобы не дублировать код
        try {
            return Util.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUsersTable() {
        try (Statement statement = createStatament()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Users(id int auto_increment,name VARCHAR(45) null,last VARCHAR(45) null,age int null, constraint Users_pk primary key (id));");
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        try (Statement statement = createStatament()) {
            statement.execute("drop table if exists Users;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("INSERT INTO Users (name, last, age) VALUES (?,?,?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Statement statement = createStatament()) {
            statement.executeUpdate(" DELETE FROM Users where id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Statement statement = createStatament()) {
            ResultSet resultSet = statement.executeQuery("SELECT * from Users;");
            while (resultSet.next()) {
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                String last = resultSet.getString("last");
                User user = new User(name, last, (byte) age);
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        try (Statement statement = createStatament()) {
            statement.executeUpdate("DELETE from Users ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

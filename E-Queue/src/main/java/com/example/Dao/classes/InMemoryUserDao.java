package com.example.Dao.classes;

import com.example.Dao.inteface.UserDao;
import com.example.model.User;

class InMemoryUserDao extends InMemoryAbstractDao<User> implements UserDao {

    InMemoryUserDao(InMemoryDatabase database) {
        super(database.users, User::getId, User::setId, database);
    }

    @Override
    public User getUserByLogin(String login) {
        return database.users.values()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

}
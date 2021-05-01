package com.example.Dao.inteface;

import com.example.model.User;

public interface UserDao extends AbstractDao<User>{
    User getUserByLogin(String login);
}

package com.example.services;

import com.example.model.MyQueue;
import com.example.model.User;

public interface UserService {

    User getByLogin(String login);

    boolean checkPassword(User user, String password);

    Integer getNumberOfUsers();

    void newUser(String login, String password, Integer id);
}

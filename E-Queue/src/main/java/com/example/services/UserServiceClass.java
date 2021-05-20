package com.example.services;

import com.example.Dao.inteface.DaoFactory;
import com.example.model.MyQueue;
import com.example.model.User;

import java.util.Collection;

public class UserServiceClass implements UserService{

    DaoFactory daoFactory;

    public UserServiceClass(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getUserByLogin(login);
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    @Override
    public Integer getNumberOfUsers() {
        Collection<User> u = daoFactory.getUserDao().findAll();
        return u.size();
    }

    @Override
    public void newUser(String login, String password, Integer id) {
        User user = new User(login, password, id);
        daoFactory.getUserDao().insert(user);
    }


}

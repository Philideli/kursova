package com.example.Dao.classes;

import com.example.Dao.inteface.DaoFactory;
import com.example.Dao.inteface.QueueDao;
import com.example.Dao.inteface.UserDao;
import com.example.model.MyQueue;
import com.example.model.User;

public class InMemoryDaoFactory implements DaoFactory {

    InMemoryDatabase database;

    QueueDao queueDao;
    UserDao userDao;

    public InMemoryDaoFactory(InMemoryDatabase database){
        this.database = database;

        queueDao = new InMemoryQueueDao(database);
        userDao = new InMemoryUserDao(database);
    }

    @Override
    public QueueDao getQueueDao() {
        return queueDao;
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }


}

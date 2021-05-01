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

    @Override
    public void addToQueue(MyQueue queue, User user){
        queueDao.addToQueue(queue,user);
    }

    @Override
    public boolean findInQueue(MyQueue queue, User user) {
        return queueDao.findInQueue(queue,user);
    }

    @Override
    public boolean isChangeable(MyQueue queue) {
        return queueDao.isChangeable(queue);
    }

    @Override
    public void deleteFromQueue(MyQueue queue, User user) {
        queueDao.deleteFromQueue(queue,user);
    }

    @Override
    public void muteQueue(MyQueue queue) {
        queueDao.muteQueue(queue);
    }

    @Override
    public void nextQueue(MyQueue queue) {
        queueDao.nextQueue(queue);
    }

    @Override
    public boolean isAdmin(User user, MyQueue queue) {
        return queueDao.isAdmin(user,queue);
    }

}

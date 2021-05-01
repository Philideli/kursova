package com.example.Dao.inteface;

import com.example.model.MyQueue;
import com.example.model.User;

public interface DaoFactory {
    QueueDao getQueueDao();
    UserDao getUserDao();
    void addToQueue(MyQueue queue, User user);
    boolean findInQueue(MyQueue queue, User user);

    boolean isChangeable(MyQueue queue);

    void deleteFromQueue(MyQueue queue, User user);

    void muteQueue(MyQueue queue);

    void nextQueue(MyQueue queue);

    boolean isAdmin(User user, MyQueue queue);
}

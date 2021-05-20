package com.example.Dao.inteface;

import com.example.model.MyQueue;
import com.example.model.User;

public interface DaoFactory {
    QueueDao getQueueDao();
    UserDao getUserDao();

}

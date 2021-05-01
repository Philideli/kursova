package com.example.Dao.classes;

import com.example.Dao.inteface.DaoFactory;
import com.example.model.MyQueue;
import com.example.model.User;

import java.util.Map;
import java.util.TreeMap;

public class InMemoryDatabase {

    Map<Integer, MyQueue> queues;
    Map<Integer, User> users;

    public InMemoryDatabase() {
        queues = new TreeMap<>();
        users = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }
}

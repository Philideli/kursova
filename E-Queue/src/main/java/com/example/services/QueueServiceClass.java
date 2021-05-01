package com.example.services;

import com.example.Dao.inteface.DaoFactory;
import com.example.model.MyQueue;
import com.example.model.User;

import java.util.Collection;

public class QueueServiceClass implements QueueService{

    DaoFactory daoFactory;

    public QueueServiceClass(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public Collection<MyQueue> getAllQueues() {
        return daoFactory.getQueueDao().findAll();
    }

    @Override
    public Collection<MyQueue> getQueuesByAdmin(User user) {
        return daoFactory.getQueueDao().getQueuesByAdmin(user);
    }

    @Override
    public MyQueue getQueuesById(Integer id) {
        return daoFactory.getQueueDao().getQueuesById(id);
    }

    @Override
    public void newQueue(String name, User user, Integer id) {
        MyQueue queue = new MyQueue(name, user, id);
        daoFactory.getQueueDao().insert(queue);
    }

    @Override
    public boolean isChangeable(MyQueue queue) {
        return daoFactory.isChangeable(queue);
    }

    @Override
    public void deleteQueueById(Integer id) {
        daoFactory.getQueueDao().delete(id);
    }

    @Override
    public void deleteFromQueue(MyQueue queue, User user) {
        daoFactory.deleteFromQueue(queue,user);
    }

    @Override
    public void muteQueue(MyQueue queue) {
        daoFactory.muteQueue(queue);
    }

    @Override
    public void nextQueue(MyQueue queue) {
        daoFactory.nextQueue(queue);
    }

    @Override
    public boolean isAdmin(User user, MyQueue queue) {
        return daoFactory.isAdmin(user,queue);
    }


    @Override
    public Integer getNumberOfQueues(){
        Collection<MyQueue> q = daoFactory.getQueueDao().findAll();
        return q.size();
    };

    @Override
    public void addToQueue(MyQueue queue,User user){
        daoFactory.addToQueue(queue,user);
    }

    @Override
    public boolean findInQueue(MyQueue queue, User user) {
        return daoFactory.findInQueue(queue,user);
    }


}

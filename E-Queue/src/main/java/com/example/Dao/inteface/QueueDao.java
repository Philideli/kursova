package com.example.Dao.inteface;

import com.example.model.MyQueue;
import com.example.model.User;

import java.util.Collection;

public interface QueueDao extends AbstractDao<MyQueue> {
    public Collection<MyQueue> getQueuesByAdmin(User user);
    public MyQueue getQueuesById(Integer id);
    public void addToQueue(MyQueue queue, User user);
    public boolean findInQueue(MyQueue queue, User user);
    public boolean isChangeable(MyQueue queue);
    public void deleteFromQueue(MyQueue queue, User user);
    public void muteQueue(MyQueue queue);
    public void nextQueue(MyQueue queue);
    public boolean isAdmin(User user, MyQueue queue);
}

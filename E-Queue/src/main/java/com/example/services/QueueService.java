package com.example.services;

import com.example.model.MyQueue;
import com.example.model.User;

import java.util.Collection;

public interface QueueService {

    Collection<com.example.model.MyQueue> getAllQueues();

    Integer getNumberOfQueues();

    Collection<MyQueue> getQueuesByAdmin(User user);

    MyQueue getQueuesById(Integer id);

    void addToQueue(MyQueue queue,User user);

    boolean findInQueue(MyQueue queue,User user);

    void newQueue(String name, User user, Integer id);

    boolean isChangeable(MyQueue queue);

    void deleteQueueById(Integer id);

    void deleteFromQueue(MyQueue queue, User user);

    void muteQueue(MyQueue queue);

    void nextQueue(MyQueue queue);


    boolean isAdmin(User user, MyQueue queue);
}

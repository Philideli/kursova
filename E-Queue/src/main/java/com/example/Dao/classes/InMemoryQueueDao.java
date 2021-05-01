package com.example.Dao.classes;

import com.example.Dao.inteface.QueueDao;
import com.example.model.MyQueue;
import com.example.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class InMemoryQueueDao extends InMemoryAbstractDao<MyQueue> implements QueueDao {
    InMemoryQueueDao(InMemoryDatabase database) {
        super(database.queues, MyQueue::getId, MyQueue::setId, database);
    }

    @Override
    public Collection<MyQueue> getQueuesByAdmin(User user) {
        return entities.values().stream().filter(o -> o.getAdmin().equals(user)).
                collect(Collectors.toCollection(ArrayList<MyQueue>::new));
    }

    @Override
    public MyQueue getQueuesById(Integer id) {
        return entities.get(id);

    }

    @Override
    public void addToQueue(MyQueue queue, User user) {
        Collection<MyQueue> q = entities.values().stream().filter(o -> o.equals(queue)).
                collect(Collectors.toCollection(ArrayList<MyQueue>::new));
        for(MyQueue item:q){
            item.addPerson(user);
        }
    }

    @Override
    public boolean findInQueue(MyQueue queue, User user) {
        Collection<MyQueue> q = entities.values().stream().filter(o -> o.equals(queue)).
                collect(Collectors.toCollection(ArrayList<MyQueue>::new));
        for(MyQueue item:q){
            return item.isInQueue(user);
        }
        return false;
    }

    @Override
    public boolean isChangeable(MyQueue queue) {
        Collection<MyQueue> q = entities.values().stream().filter(o -> o.equals(queue)).
                collect(Collectors.toCollection(ArrayList<MyQueue>::new));
        for(MyQueue item:q){
            return item.isChangeable();
        }
        return false;
    }

    @Override
    public void deleteFromQueue(MyQueue queue, User user) {
        Collection<MyQueue> q = entities.values().stream().filter(o -> o.equals(queue)).
                collect(Collectors.toCollection(ArrayList<MyQueue>::new));
        for(MyQueue item:q){
            item.deletePerson(user);
        }
    }

    @Override
    public void muteQueue(MyQueue queue) {
        Collection<MyQueue> q = entities.values().stream().filter(o -> o.equals(queue)).
                collect(Collectors.toCollection(ArrayList<MyQueue>::new));
        for(MyQueue item:q){
            item.setChangeable();
        }
    }

    @Override
    public void nextQueue(MyQueue queue) {
        Collection<MyQueue> q = entities.values().stream().filter(o -> o.equals(queue)).
                collect(Collectors.toCollection(ArrayList<MyQueue>::new));
        for(MyQueue item:q){
            item.nextPerson();
        }
    }

    @Override
    public boolean isAdmin(User user, MyQueue queue) {
        Collection<MyQueue> q = entities.values().stream().filter(o -> o.equals(queue)).
                collect(Collectors.toCollection(ArrayList<MyQueue>::new));
        for(MyQueue item:q){
            return item.isAdmin(user);
        }
        return false;
    }

}

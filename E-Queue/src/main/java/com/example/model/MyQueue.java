package com.example.model;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MyQueue {

    private Integer id;
    private String name;
    private Queue<User> queue = new LinkedList<User>();
    private User admin;
    private boolean changeable;

    public MyQueue(String name, User admin, Integer id) {
        this.name = name;
        this.admin = admin;
        changeable = true;
        this.id = id;
    }

    public void addPerson(User user){
        if (changeable)
            queue.offer(user);
    }

    public void deletePerson(User user){
        if (changeable)
            queue.remove(user);
    }

    public boolean isInQueue(User user){
        return queue.contains(user);
    }

    public void nextPerson(){
        queue.poll();
    }

    public Integer numberInQueue(User user){
        int number = 1;
        for (User items:queue){
            if (items.equals(user))
                return number;
            number++;
        }
        return number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Queue<User> getQueue() {
        return queue;
    }

    public User getAdmin() {
        return admin;
    }

    public boolean isAdmin(User user){
        return admin.equals(user);
    };

    public boolean isChangeable() {
        return changeable;
    }

    public void setChangeable() {
        this.changeable = !this.isChangeable();
    }

    public String printChangeable(){
        if(this.isChangeable())
        return "Muttable";
        else
            return "Immutable";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyQueue myQueue = (MyQueue) o;
        return changeable == myQueue.changeable && Objects.equals(id, myQueue.id) &&
                Objects.equals(name, myQueue.name) && Objects.equals(queue, myQueue.queue) &&
                Objects.equals(admin, myQueue.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, queue, admin, changeable);
    }
}
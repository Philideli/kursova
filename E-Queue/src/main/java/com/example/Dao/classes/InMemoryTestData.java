package com.example.Dao.classes;

import com.example.model.MyQueue;
import com.example.model.User;

public class InMemoryTestData {

    public static void generateTo(InMemoryDatabase database) {

        database.queues.clear();
        database.users.clear();

        User first = new User("FirstUser", "first", 1);
        User second = new User("SecondUser", "second", 2);
        User third = new User("ThirdUser", "third", 3);
        User fourth = new User("FourthUser","fourth",4);
        User fifth = new User("FifthUser","fifth",4);

        MyQueue q1 = new MyQueue("firstQueue", first, 1);
        MyQueue q2 = new MyQueue("secondQueue", first, 2);
        MyQueue q3 = new MyQueue("thirdQueue", second, 3);

        q1.addPerson(first);
        q1.addPerson(second);
        q1.addPerson(third);
        q1.addPerson(fourth);
        q1.addPerson(fifth);

        q2.addPerson(second);
        q2.addPerson(fifth);
        q2.addPerson(first);

        q3.addPerson(fourth);
        q3.addPerson(fifth);

        database.users.put(first.getId(), first);
        database.users.put(second.getId(), second);
        database.users.put(third.getId(), third);
        database.users.put(fourth.getId(), fourth);
        database.users.put(fifth.getId(), fifth);

        database.queues.put(q1.getId(), q1);
        database.queues.put(q2.getId(), q2);
        database.queues.put(q3.getId(), q3);
    }
}
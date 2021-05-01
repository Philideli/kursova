package com.example.Dao.classes;

import com.example.model.MyQueue;
import com.example.model.User;

public class InMemoryTestData {

    public static void generateTo(InMemoryDatabase database) {

        database.queues.clear();
        database.users.clear();

        User lubitelIzuma = new User("izumchik", "kapets", "+380999999999", 1);
        User nelubitelIzuma = new User("neizumchik", "kruto", "+380888888888", 2);
        User first = new User("FirstUser", "kruto", "+380888888888", 3);
        User second = new User("SecondUser", "kruto", "+380888888888", 4);
        User third = new User("ThirdUser", "kruto", "+380888888888", 5);

        User admin = new User("admin", "admin", "+38000000000", 6);

        MyQueue izum = new MyQueue("firstQueue", lubitelIzuma, 1);
        MyQueue voda = new MyQueue("secondQueue", lubitelIzuma, 2);

        izum.addPerson(lubitelIzuma);
        izum.addPerson(nelubitelIzuma);
        izum.addPerson(first);
        izum.addPerson(second);
        izum.addPerson(third);

        voda.addPerson(second);
        voda.addPerson(nelubitelIzuma);
        voda.addPerson(first);

        database.users.put(lubitelIzuma.getId(), lubitelIzuma);
        database.users.put(nelubitelIzuma.getId(), nelubitelIzuma);
        database.users.put(first.getId(), first);
        database.users.put(second.getId(), second);
        database.users.put(third.getId(), third);

        database.queues.put(izum.getId(), izum);
        database.queues.put(voda.getId(), voda);
    }
}
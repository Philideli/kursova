package com.example.controllers;

import com.example.Dao.classes.InMemoryDatabase;
import com.example.Dao.classes.InMemoryTestData;
import com.example.Dao.inteface.DaoFactory;
import com.example.services.QueueService;
import com.example.services.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Change to real database in real project
        InMemoryDatabase database = new InMemoryDatabase();

        // Don't use in real project
        InMemoryTestData.generateTo(database);

        DaoFactory daoFactory = database.getDaoFactory();

        QueueService queueService = new QueueServiceClass(daoFactory);
        sce.getServletContext().setAttribute("queueService", queueService);

        UserService userService = new UserServiceClass(daoFactory);
        sce.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

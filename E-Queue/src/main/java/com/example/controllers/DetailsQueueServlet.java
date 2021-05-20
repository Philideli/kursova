package com.example.controllers;

import com.example.model.MyQueue;
import com.example.model.User;
import com.example.services.QueueService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class DetailsQueueServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        QueueService queueService = (QueueService) context.getAttribute("queueService");

        Collection<MyQueue> queues = queueService.getQueuesByAdmin((User) request.getSession().getAttribute("user"));

        request.setAttribute("userqueues", queues);

        request.getRequestDispatcher("/WEB-INF/jsp/detailsQueues.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

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

public class AddToQueue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        QueueService queueService = (QueueService) context.getAttribute("queueService");

        if(request.getParameter("idAdd") == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }

        MyQueue queueId = queueService.getQueuesById(Integer.parseInt(request.getParameter("idAdd")));
        if (!queueService.findInQueue(queueId, (User) request.getSession().getAttribute("user")) &&
                queueService.isChangeable(queueId)){
            queueService.addToQueue(queueId, (User) request.getSession().getAttribute("user"));
            request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }
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

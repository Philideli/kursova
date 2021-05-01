package com.example.controllers;

import com.example.model.MyQueue;
import com.example.model.User;
import com.example.services.QueueService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MuteQueue extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        QueueService queueService = (QueueService) context.getAttribute("queueService");

        if(request.getParameter("idMute") == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }

        //MyQueue queueId = (MyQueue) request.getParameter("queue");
        MyQueue queueId = queueService.getQueuesById(Integer.parseInt(request.getParameter("idMute")));
        if (queueService.isAdmin((User) request.getSession().getAttribute("user"), queueId))
        {
            queueService.muteQueue(queueId);
            request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

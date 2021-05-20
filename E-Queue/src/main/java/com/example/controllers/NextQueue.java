package com.example.controllers;

import com.example.model.MyQueue;
import com.example.model.User;
import com.example.services.QueueService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class NextQueue extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        QueueService queueService = (QueueService) context.getAttribute("queueService");

        if(request.getParameter("idNext") == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }

        MyQueue queueId = queueService.getQueuesById(Integer.parseInt(request.getParameter("idNext")));

        if (queueService.isAdmin((User) request.getSession().getAttribute("user"), queueId))
        {
            queueService.nextQueue(queueId);
            request.getRequestDispatcher("/DetailsQueueServlet").forward(request, response);
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

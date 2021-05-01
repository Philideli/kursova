package com.example.controllers;

import com.example.model.MyQueue;
import com.example.model.User;
import com.example.services.QueueService;
import com.example.services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFromQueue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        QueueService queueService = (QueueService) context.getAttribute("queueService");
        UserService userService = (UserService) context.getAttribute("userService");

        if(request.getParameter("idDel") == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }

        if(request.getParameter("del") == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }

        User userLogin = userService.getByLogin(request.getParameter("del"));
        MyQueue queueId = queueService.getQueuesById(Integer.parseInt(request.getParameter("idDel")));
        if (queueService.findInQueue(queueId, userLogin) &&
                queueService.isChangeable(queueId) &&
                queueService.isAdmin((User) request.getSession().getAttribute("user"), queueId)){
            queueService.deleteFromQueue(queueId, userLogin);
            request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
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

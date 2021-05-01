package com.example.controllers;

import com.example.model.User;
import com.example.services.QueueService;
import com.example.services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewQueue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        ServletContext context = getServletContext();
        QueueService queueService = (QueueService) context.getAttribute("queueService");

        if(request.getParameter("name") == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }

        Integer id = queueService.getNumberOfQueues() + 1;

        queueService.newQueue(request.getParameter("name").toString(), (User) request.getSession().getAttribute("user"),
                id);

        request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
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

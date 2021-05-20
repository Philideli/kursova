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

public class NewUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        request.getSession().invalidate();

        ServletContext context = getServletContext();
        UserService userService = (UserService) context.getAttribute("userService");

        String log = request.getParameter("login");
        String pass = request.getParameter("password");

        if(log == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }

        if(pass == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }

        Integer id = userService.getNumberOfUsers() + 1;

        userService.newUser(log, pass, id);

        User user = userService.getByLogin(log);

        request.getSession().setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);
        //request.getRequestDispatcher("login.jsp").forward(request, response);
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

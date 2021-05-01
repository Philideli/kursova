package com.example.controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import com.example.services.*;
import com.example.model.*;

//@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        request.getSession().invalidate();

        ServletContext context = getServletContext();
        UserService userService = (UserService) context.getAttribute("userService");

        String log = request.getParameter("login");
        User user = userService.getByLogin(log);

        if (user == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/firstError.jsp").forward(request, response);
            return;
        }

        String pass = request.getParameter("password");

        if (!userService.checkPassword(user, pass)) {
            request.getRequestDispatcher("/WEB-INF/jsp/firstError.jsp").forward(request, response);
            return;
        }

        request.getSession().setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);

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

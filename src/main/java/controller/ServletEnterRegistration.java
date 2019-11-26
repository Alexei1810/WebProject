package controller;

import models.User;
import service.ClassLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletRegistration")
public class ServletEnterRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User(req.getParameter("name"),req.getParameter("password"));
        ClassLogic classLogic=new ClassLogic();
        boolean flag=classLogic.createUser(user);
        if(flag){
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            req.setAttribute("message", "Такой логин занят");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/registration.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

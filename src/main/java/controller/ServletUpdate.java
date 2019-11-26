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

@WebServlet("/servletUpdate")
public class ServletUpdate extends HttpServlet {
    ClassLogic service=new ClassLogic();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id",req.getParameter("id"));
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("password",req.getParameter("password"));
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/updateUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));
        service.updateUser(user);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/servletLogin");
        requestDispatcher.forward(req, resp);
    }
}

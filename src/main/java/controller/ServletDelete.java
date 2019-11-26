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

@WebServlet("/servletDelete")
public class ServletDelete extends HttpServlet {
    ClassLogic service=new ClassLogic();
    User user=new User();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id",req.getParameter("id"));
        req.setAttribute("name",req.getParameter("name"));
        req.setAttribute("password",req.getParameter("password"));
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/deleteUser.jsp");
       requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.deleteUser(Integer.parseInt(req.getParameter("id")));
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/enter.jsp");
        requestDispatcher.forward(req, resp);
    }
}

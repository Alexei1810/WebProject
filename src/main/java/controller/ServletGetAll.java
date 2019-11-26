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

@WebServlet("/servletGetAll")
public class ServletGetAll extends HttpServlet {
    ClassLogic service=new ClassLogic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", service.showUsers());
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("password", req.getParameter("password"));
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/getAll.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User();
        user.setName(req.getParameter("login"));
        user.setPassword(req.getParameter("pass"));
        boolean flag=service.createUser(user);
        if(flag){
            req.setAttribute("name",req.getParameter("name") );
            req.setAttribute("password", req.getParameter("password"));
            req.setAttribute("users", service.showUsers());
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/getAll.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            req.setAttribute("name",req.getParameter("name") );
            req.setAttribute("password", req.getParameter("password"));
            req.setAttribute("message", "Такой логин занят");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/createUser.jsp");
            requestDispatcher.forward(req, resp);
        }


    }
}

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

@WebServlet("/servletLogin")
public class ServletEnterLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User(req.getParameter("name"),req.getParameter("password"));
        ClassLogic classLogic=new ClassLogic();
        User userInfo=classLogic.toMyPage(user);
        if(userInfo.getId()!=0){
            req.setAttribute("user",userInfo);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/userPage.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            req.setAttribute("message", "Неверные данные!");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

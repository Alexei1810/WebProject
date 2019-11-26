package controller;

import service.ClassLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getAllDelete")
public class ServletGetAllDelete extends HttpServlet {
    ClassLogic service=new ClassLogic();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name",req.getParameter("name"));
        req.setAttribute("password", req.getParameter("password"));
        service.deleteUser(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("users", service.showUsers());
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/getAll.jsp");
        requestDispatcher.forward(req, resp);
    }
}

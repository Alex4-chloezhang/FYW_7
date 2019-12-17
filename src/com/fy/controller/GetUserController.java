package com.fy.controller;

import com.fy.dao.UserDaoImpl;
import com.fy.model.User;
import com.fy.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetUserController", urlPatterns = "/getUser")

public class GetUserController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserServiceImpl usi = new UserServiceImpl();
        User u = usi.getUser(username, password);
        if (u != null) {
            if (u.getId() > 0) {
                HttpSession session = req.getSession();
                session.setAttribute("u", u);
                resp.sendRedirect(req.getContextPath() + "/findItemAll");
            } else {
                resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/login.jsp");
            }
        }
    }
}

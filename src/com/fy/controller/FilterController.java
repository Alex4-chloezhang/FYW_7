package com.fy.controller;

import com.fy.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterController", urlPatterns = "/*", servletNames = "*Controller")
public class FilterController implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hsrreq = (HttpServletRequest) req;
        HttpServletResponse hsrresp = (HttpServletResponse) resp;

        HttpSession session = hsrreq.getSession();
        User u = (User) session.getAttribute("u");
        //System.out.println("uri:"+req.getRequestURI());
        if (u == null) {//登录
            String uri = hsrreq.getRequestURI();
            if (!uri.contains("login")) {
                if (u != null) {//会话存在,也不是登录的url路径地址则重新放置session会话
                    hsrreq.getSession().setAttribute("u", u);
                } else {//既没有session会话,也不是login的url则让期跳转到登录页
                    hsrreq.getRequestDispatcher("/login.jsp").forward(req, resp);
                    //resp.sendRedirect(req.getContextPath()+"/login.jsp");
                }
            }
        } else {
            System.out.println("user会话已存在");
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

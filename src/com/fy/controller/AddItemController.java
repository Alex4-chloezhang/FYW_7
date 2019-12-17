package com.fy.controller;

import com.fy.model.Item;
import com.fy.service.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddItemController", urlPatterns = "/addItem")

public class AddItemController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String destr = req.getParameter("destr");
        int num = Integer.valueOf(req.getParameter("num") == null ? "" : req.getParameter("num"));

        ItemServiceImpl isi = new ItemServiceImpl();
        int addCount = isi.addItem(new Item(name, destr, num));

        if (addCount>0){
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        resp.sendRedirect(req.getContextPath() + "/findItemAll");
    }
}

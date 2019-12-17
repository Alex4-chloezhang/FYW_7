package com.fy.controller;

import com.fy.model.Item;
import com.fy.service.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateItemController", urlPatterns = "/updateItem")

public class UpdateItemController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.valueOf(req.getParameter("id") == "" ? "0" : req.getParameter("id"));
        String name = req.getParameter("name");
        String destr = req.getParameter("destr");
        int num = Integer.valueOf(req.getParameter("num") == "" ? "0" : req.getParameter("num"));
        ItemServiceImpl isi = new ItemServiceImpl();
        int updateCount = 0;
        if (id > 0) {
            updateCount = isi.updateItem(new Item(id, name, destr, num));
            if (updateCount > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        }
        resp.sendRedirect(req.getContextPath() + "/findItemAll");
    }
}

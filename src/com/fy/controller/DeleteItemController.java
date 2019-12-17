package com.fy.controller;

import com.fy.service.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteItemController", urlPatterns = "/deleteItem")

public class DeleteItemController extends HttpServlet {
    protected void doPost(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
        doGet(requ, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id") == "" ? "0" : req.getParameter("id"));
        int deleteCount = 0;
        ItemServiceImpl isi = new ItemServiceImpl();

        if (id > 0) {
            deleteCount = isi.deleteItem(id);
            if (deleteCount > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }

        resp.sendRedirect(req.getContextPath() + "/findItemAll");
    }
}

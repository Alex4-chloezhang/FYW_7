package com.fy.controller;

import com.fy.model.Item;
import com.fy.service.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetItemController", urlPatterns = "/getItem")

public class GetItemController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id") == "" ? "0" : req.getParameter("id"));

        ItemServiceImpl isi = new ItemServiceImpl();
        Item item = isi.getItem(id);
        req.setAttribute("im", item);
        req.getRequestDispatcher("/updateItem.jsp").forward(req, resp);
    }
}

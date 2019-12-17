package com.fy.controller;

import com.fy.model.Item;
import com.fy.service.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FindItemAllController", urlPatterns = "/findItemAll")

public class FindItemAllController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items;

        ItemServiceImpl isi = new ItemServiceImpl();

        items = isi.findItemAll();

        req.setAttribute("items", items);
        req.getRequestDispatcher("/itemList.jsp").forward(req, resp);
    }
}

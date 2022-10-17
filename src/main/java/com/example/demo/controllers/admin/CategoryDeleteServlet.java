package com.example.demo.controllers.admin;

import com.example.demo.service.CategoryService;
import com.example.demo.service.interfaces.ICategoryService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CategoryDeleteServlet", value = "/admin/category/delete")
public class CategoryDeleteServlet extends HttpServlet {
    ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        categoryService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/category/list");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

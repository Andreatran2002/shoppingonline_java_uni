package com.example.demo.controllers.admin;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.interfaces.ICategoryService;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.List;

@WebServlet(name = "AdminCategoryList", value =  "/admin/category/list" )
public class CategoryController extends HttpServlet {
    ICategoryService cateService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse
            resp) throws IOException, ServletException {
        List<Category> cateList = cateService.getAll();
        resp.setContentType("text/html");
        System.out.println(cateList) ;
        req.setAttribute("cateList", cateList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-category.jsp");
        dispatcher.forward(req, resp);
    }
}
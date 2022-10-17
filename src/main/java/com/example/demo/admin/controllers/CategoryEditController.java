package com.example.demo.admin.controllers;

import com.example.demo.admin.model.Category;
import com.example.demo.admin.service.CategoryService;
import com.example.demo.admin.service.interfaces.ICategoryService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@MultipartConfig
@WebServlet(name = "CategoryEditController", value = "/admin/category/edit")
public class CategoryEditController extends HttpServlet {
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Category category = categoryService.get(Integer.parseInt(id));
        req.setAttribute("category", category);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/views/admin/edit-category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Category oldCate = categoryService.get(id);

        System.out.println(oldCate);
        System.out.println("oldcate");

        try{
            String name = req.getParameter("name");
            String status = req.getParameter("status");
            oldCate.setCatename(name);
            oldCate.setStatus(status);
            Part part = req.getPart("images");
            String realPath = req.getServletContext().getRealPath("/uploads");
            String filename
                = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Paths.get(realPath))) {
            Files.createDirectory(Paths.get(realPath));
        }
            part.write(realPath + "/" + filename);
        oldCate.setImages(filename);
            categoryService.edit(oldCate);
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");

        }
        catch(Exception e){
            System.out.println(e);
        }

}



}

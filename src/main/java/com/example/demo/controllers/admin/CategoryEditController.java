package com.example.demo.controllers.admin;

import com.example.demo.common.Constant;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.interfaces.ICategoryService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(name = "CategoryEditController", value = "/admin/category/edit")
public class CategoryEditController extends HttpServlet {
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("I am runing");

        Category category = categoryService.get(Integer.parseInt(id));
        System.out.println(category);
        req.setAttribute("category", category);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/views/admin/edit-category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = new Category();
        DiskFileItemFactory diskFileItemFactory = new
                DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new
                ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        try {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            List<FileItem> items = servletFileUpload.parseRequest(req);
            for (FileItem item : items) {
                if (item.getFieldName().equals("id")) {
                    category.setCateid(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("name")) {
                    category.setCatename(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("icon")) {
                    if (item.getSize() > 0) {// neu co file d
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;
                        File file = new File(Constant.path + "/category/" + fileName);
                        item.write(file);
                        category.setIcon("category/"+fileName);
                    } else {
                        category.setIcon(null);}}}
            categoryService.edit(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {e.printStackTrace();}

    }
}
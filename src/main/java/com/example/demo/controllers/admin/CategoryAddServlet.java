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
import java.util.List;

@WebServlet(name = "CategoryAddServlet", value = "/admin/category/add")
public class CategoryAddServlet extends HttpServlet {
    ICategoryService categoryService  = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws IOException, ServletException {
        response.setContentType("text/html");
        System.out.println("HIHIHI");

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/views/admin/add-category.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HIHIHI");
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
                if (item.getFieldName().equals("name")) {
                    category.setCatename(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("icon")) {
                    String originalFileName = item.getName();
                    int index = originalFileName.lastIndexOf(".");
                    String ext = originalFileName.substring(index + 1);
                    String fileName = System.currentTimeMillis() + "." + ext;
                    File file = new File(Constant.path + "/category/" + fileName);
                    item.write(file);
                    category.setIcon("category/"+fileName);
                    category.setStatus(1);
                }
            }
            categoryService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.example.demo.service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.model.Category;
import com.example.demo.admin.dao.interfaces.ICategoryDAO;
import com.example.demo.service.interfaces.ICategoryService;

import java.io.File;
import java.util.List;

public class CategoryService  implements ICategoryService {
    public String link = "/Users/andreatran/StudySpace/School/hk1_3/web/testFile";
    ICategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public void insert(Category category) {
        categoryDAO.insert(category);
    }

    @Override
    public void edit(Category category) {
        Category oldCategory = categoryDAO.get(category.getCateid());
        oldCategory.setCatename(category.getCatename());
        oldCategory.setStatus(category.getStatus());
        if (category.getImages() != null) {
            String fileName = oldCategory.getImages();
            final String dir = link+"/upload";
            File file = new File(dir + "/category" + fileName);
            if (file.exists()) {
                file.delete();
            }
            oldCategory.setImages(category.getImages());
        }
        categoryDAO.edit(oldCategory);

    }

    @Override
    public void delete(int id) {
        categoryDAO.delete(id);
    }

    @Override
    public Category get(int id) {
        return categoryDAO.get(id);
    }

    @Override
    public Category get(String name) {
        return categoryDAO.get(name);

    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDAO.search(keyword);
    }
}

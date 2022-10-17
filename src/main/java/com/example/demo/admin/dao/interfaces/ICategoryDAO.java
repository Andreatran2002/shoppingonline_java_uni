package com.example.demo.admin.dao.interfaces;

import com.example.demo.admin.model.Category;

import java.util.List;

public interface ICategoryDAO {
    void insert(Category category);
    void edit(Category category);
    void delete(int id);
    Category get(int id);
    Category get(String name);
    List<Category> getAll();
    List<Category> search(String keyword);
}
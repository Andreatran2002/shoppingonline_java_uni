package com.example.shopping_api.Service;

import com.example.shopping_api.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> findCategory(Integer id);
    List<Category> findAll();
    Category save(Category Category);
    Category update(Category Category);
    void delete(Category Category);
}
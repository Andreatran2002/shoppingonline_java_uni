package com.example.shopping_api.Repository;

import com.example.shopping_api.model.Category;
import com.example.shopping_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
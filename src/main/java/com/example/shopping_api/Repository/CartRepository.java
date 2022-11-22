package com.example.shopping_api.Repository;

import com.example.shopping_api.model.Cart;
import com.example.shopping_api.model.Category;
import com.example.shopping_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("SELECT c FROM Cart c WHERE c.userId = ?1")
    List<Cart> findCartByUser(Integer userId);
}
package com.example.shopping_api.Service;

import com.example.shopping_api.model.Cart;
import com.example.shopping_api.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Optional<Cart> findCart(Integer id);
    List<Cart> findByUser(Integer userId);
    List<Cart> findAll();
    Cart update(Cart item);
    Cart create(Cart item);


}
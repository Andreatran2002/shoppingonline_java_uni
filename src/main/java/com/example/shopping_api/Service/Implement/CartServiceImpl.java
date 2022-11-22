package com.example.shopping_api.Service.Implement;

import com.example.shopping_api.Repository.CartRepository;
import com.example.shopping_api.Service.CartService;
import com.example.shopping_api.model.Cart;
import com.example.shopping_api.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository ;

    @Override
    public Optional<Cart> findCart(Integer id) {
        return cartRepository.findById(id);
    }

    @Override
    public List<Cart> findByUser(Integer userId) {
        return cartRepository.findCartByUser(userId);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll(Sort.by(Sort.Direction.DESC, "buydate"));
    }

    @Override
    public Cart update(Cart item) {
        return cartRepository.save(item);
    }

    @Override
    public Cart create(Cart item) {
        return cartRepository.save(item);
    }
}

package com.example.shopping_api.controller.common;

import com.example.shopping_api.Service.CartService;
import com.example.shopping_api.Service.Implement.CartServiceImpl;
import com.example.shopping_api.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    private CartService cartService = new CartServiceImpl();

    @GetMapping("{id}")
    public ResponseEntity<Cart> findCart(@PathVariable Integer id) {
        Optional<Cart> cartOptional = cartService.findCart(id);
        return cartOptional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Cart>> findAll() {
        return ResponseEntity.ok(cartService.findAll());
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Cart>> pagination(@PathVariable Integer userId) {
        return ResponseEntity.ok(cartService.findByUser(userId));
    }


}
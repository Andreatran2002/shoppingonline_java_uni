package com.example.shopping_api.controller.admin;

import com.example.shopping_api.Service.CategoryService;
import com.example.shopping_api.Service.Implement.CategoryServiceImpl;
import com.example.shopping_api.Service.Implement.ProductServiceImpl;
import com.example.shopping_api.Service.ProductService;
import com.example.shopping_api.Service.UserService;
import com.example.shopping_api.model.Category;
import com.example.shopping_api.model.Product;
import com.example.shopping_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("api/v1/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<User> findUser(@PathVariable Integer id) {
        Optional<User> userOptional = userService.findUser(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(consumes = {"application/xml","application/json"})
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

}
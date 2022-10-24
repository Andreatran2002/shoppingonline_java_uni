package com.example.shopping_api.Service;

import com.example.shopping_api.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUser(Integer id);
    List<User> findAll();
    User save(User user);
    User update(User user);
    void delete(User user);
    Boolean isAuthenticated(String name, String password);
}
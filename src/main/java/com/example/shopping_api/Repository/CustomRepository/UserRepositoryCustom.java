package com.example.shopping_api.Repository.CustomRepository;

import com.example.shopping_api.model.User;

public interface UserRepositoryCustom {

    User getByName(String name);
}
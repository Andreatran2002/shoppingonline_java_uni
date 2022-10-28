package com.example.shopping_api.Repository;

import com.example.shopping_api.Repository.CustomRepository.UserRepositoryCustom;
import com.example.shopping_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
    @Query("SELECT u FROM User u WHERE u.name = ?1")
    User findUserByName(String name);
}
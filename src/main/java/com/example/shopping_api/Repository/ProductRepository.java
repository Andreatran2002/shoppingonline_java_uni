package com.example.shopping_api.Repository;

import com.example.shopping_api.model.Product;
import com.example.shopping_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value="select * from product order by createdate DESC LIMIT  0,?",nativeQuery = true)
    List<Product> getNewProducts( Integer amount );
    @Query(value="select * from product where name LIKE ?;",nativeQuery = true)
    List<Product> searchProduct( String key );

    @Query(value="select * from product where cate_id = ? LIMIT  ?,10;",nativeQuery = true)
    List<Product> getByCate( Integer id ,Integer page);
}
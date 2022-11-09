package com.example.shopping_api.Service;

import com.example.shopping_api.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findProduct(Integer id);
    List<Product> findAll();
    List<Product> getNewProducts( Integer amount);
    List<Product> searchProducts( String key);
    List<Product> getByPage(Integer page, Integer amount);

    Product save(Product Product);
    Product update(Product Product);
    void delete(Product Product);
    List<Product> getByCate(Integer cateid,Integer page);
}
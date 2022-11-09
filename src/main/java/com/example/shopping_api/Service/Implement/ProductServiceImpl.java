package com.example.shopping_api.Service.Implement;

import com.example.shopping_api.Repository.ProductRepository;
import com.example.shopping_api.Repository.ProductRepository;
import com.example.shopping_api.Service.ProductService;
import com.example.shopping_api.Service.ProductService;
import com.example.shopping_api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findProduct(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> getNewProducts( Integer amount) {
        return  productRepository.getNewProducts(amount);
    }

    @Override
    public List<Product> searchProducts(String key) {
        return productRepository.searchProduct("%"+key+"%");
    }

    @Override
    public List<Product> getByPage(Integer page, Integer amount) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public List<Product> getByCate(Integer cateid, Integer page) {
        return productRepository.getByCate(cateid,page*10);
    }
}
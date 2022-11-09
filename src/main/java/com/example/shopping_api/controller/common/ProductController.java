package com.example.shopping_api.controller.common;

import com.example.shopping_api.Service.ProductService;
import com.example.shopping_api.Service.ProductService;
import com.example.shopping_api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<Product> findProduct(@PathVariable Integer id) {
        Optional<Product> productOptional = productService.findProduct(id);
        return productOptional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("new/{amount}")
    public ResponseEntity<List<Product>> getNewProducts(@PathVariable Integer amount) {
        return ResponseEntity.ok(productService.getNewProducts( amount));
    }

    @GetMapping("search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String key) {
        return ResponseEntity.ok(productService.searchProducts( key));
    }
    @GetMapping("/category")
    public ResponseEntity<List<Product>> pagination(@RequestParam Integer id,@RequestParam Integer page) {
        return ResponseEntity.ok(productService.getByCate( id,page));
    }


}
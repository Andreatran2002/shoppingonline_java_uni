//package com.example.shopping_api.controller.seller;
//
//
//import com.example.shopping_api.Service.ProductService;
//import com.example.shopping_api.Service.UserService;
//import com.example.shopping_api.model.Product;
//import com.example.shopping_api.model.Request.CreateProductRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/v1/seller/{sellerId}/product")
//public class ProductController {
//
//
//
//    @Autowired
//    private UserService userService;
//    private ProductService productService;
//
//    @GetMapping("{id}")
//    public ResponseEntity<Product> findProduct(@PathVariable Integer id) {
//        Optional<Product> productOptional = productService.findProduct(id);
//        return productOptional.map(ResponseEntity::ok)
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Product>> findAll() {
//        return ResponseEntity.ok(productService.findAll());
//    }
//
//    @PostMapping(consumes = {"application/xml","application/json"})
//    public ResponseEntity<Product> save(@RequestBody CreateProductRequest req ) {
//
//        if (userService.isAuthenticated(req.user.name, req.user.password)){
//            return ResponseEntity.ok(productService.save(req.product));
//        }
//        return new  ResponseEntity<>(HttpStatus.FORBIDDEN);
//
//    }
//
//    @PutMapping
//    public ResponseEntity<Product> update(@RequestBody CreateProductRequest req ) {
//        if (userService.isAuthenticated(req.user.name, req.user.password)){
//
//            return ResponseEntity.ok(productService.update(req.product));
//
//        }
//        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//    }
//
//    @DeleteMapping
//    public void delete(@RequestBody Product product) {
//        productService.delete(product);
//    }
//}
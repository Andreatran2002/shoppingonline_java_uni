package com.example.shopping_api;

import com.example.shopping_api.Service.CategoryService;
import com.example.shopping_api.Service.Implement.CategoryServiceImpl;
import com.example.shopping_api.Service.Implement.ProductServiceImpl;
import com.example.shopping_api.Service.ProductService;
import com.example.shopping_api.model.Category;
import com.example.shopping_api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Random;

@SpringBootApplication
public class ShoppingApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppingApiApplication.class, args);

//		( new FakeDb()).FakeDatabase();
	}
//	public static class FakeDb{
//		@Autowired
//		private CategoryService categoryService;
//		@Autowired
//		private ProductService productServce ;
//		public  void FakeDatabase(){
////		CategoryService categoryService = new CategoryServiceImpl();
//
//			Random rand = new Random(); //instance of random class
//
//			for (int i = 0 ; i< 1 ; i++){
//				categoryService.save(new Category("Category "+ i , "image.png", 1));
//			}
//			for (int i = 0 ; i< 100 ; i++){
//				productServce.save(new Product("Product "+ i ,"Code "+i ,rand.nextInt(10),
//						"Description "+i , (float) rand.nextInt(89999),rand.nextInt(500), rand.nextInt(569), "image.png", 0,1,1));
//			}
//
//
//
//		}
//	}

}

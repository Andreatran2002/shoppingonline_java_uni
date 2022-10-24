package com.example.shopping_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@SpringBootApplication
public class ShoppingApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppingApiApplication.class, args);
	}
}

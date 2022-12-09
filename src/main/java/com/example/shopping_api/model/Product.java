package com.example.shopping_api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "cate_id")
    private Integer cateId;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "image")
    private String image;

    @Column(name = "wishlist")
    private Integer wishlist;

    @Column(name = "status")
    private Integer status;

    @Column(name = "createdate")
    private Date createDate = Date.from(Instant.now());

    @Column(name = "seller_id")
    private Integer sellerId;

    public Product(String name, String code, Integer cateId, String description, Float price, Integer amount, Integer stock, String image, Integer wishlist, Integer status, Integer sellerId) {
        this.name = name;
        this.code = code;
        this.cateId = cateId;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.stock = stock;
        this.image = image;
        this.wishlist = wishlist;
        this.status = status;
        this.sellerId = sellerId;
    }

    public Product() {

    }
}
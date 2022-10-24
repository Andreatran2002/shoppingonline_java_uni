package com.example.shopping_api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String cateId;

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

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "sellerId")
    private Integer sellerId;


    @Column(name = "city")
    private String city;
}
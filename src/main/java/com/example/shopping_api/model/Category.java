package com.example.shopping_api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable =  false )
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String icon;

    public Category(String name, String icon, Integer status) {
        this.name = name;
        this.icon = icon;
        this.status = status;
    }

    @Column(name = "status")
    private Integer status;

    public Category() {

    }
}
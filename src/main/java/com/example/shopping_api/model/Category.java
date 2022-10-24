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
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable =  false )
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String icon;

    @Column(name = "status")
    private Integer status;
}
package com.example.shopping_api.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "fullname")
    private String fullName;
    @Column(name = "password")
    private String password;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private Integer status;

    @Column(name = "phone")
    private String phone;
    @Column(name = "code")
    private String code;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "seller_id")
    private Integer sellerId;
}
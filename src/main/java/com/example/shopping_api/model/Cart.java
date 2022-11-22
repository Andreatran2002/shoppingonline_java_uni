package com.example.shopping_api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cart")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid" )
    private Integer id;

    @Column(name = "userid")
    private Integer userId;

    @Column(name = "buydate")
    private Date buyDate;

    @Column(name = "status")
    private Integer status;
}

package com.example.shopping_api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CartItem")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartitemid" )
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unitprice")
    private Double unitPrice;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "cartid")
    private Integer cartId;
}
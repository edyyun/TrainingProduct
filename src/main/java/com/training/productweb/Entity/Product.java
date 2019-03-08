package com.training.productweb.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private double productPrice;
    @Column(name = "productQty")
    private int productQty;
    @Column(name = "productDesc")
    private String productDesc;
    @Column(name = "categoryId")
    private Long categoryId;
}

package com.training.productweb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int productId;
    private String productName;
    private int productPrice;
    private int productQty;
    private String productDesc;
    private int categoryId;
}

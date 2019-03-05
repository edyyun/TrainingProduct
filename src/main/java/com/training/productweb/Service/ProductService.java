package com.training.productweb.Service;

import com.training.productweb.Model.Product;

import java.util.ArrayList;

public interface ProductService {
    Product create(Product product);
    Product findById(int id);
    ArrayList<Product> findAll();
    Product update(Product product);
    Product delete (int id);
}

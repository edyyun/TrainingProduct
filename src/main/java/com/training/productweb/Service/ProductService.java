package com.training.productweb.Service;

import com.training.productweb.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product findById(Long id);
    List<Product> findAll();
    Product update(Product product,Long id);
    Product delete (Long id);
}

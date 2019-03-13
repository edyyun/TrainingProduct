package com.training.productweb.Service;

import com.training.productweb.Entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product findById(Long id);
    List<Product> findAll();
    Product update(Product product,Long id);
    Product delete (Long id);
}

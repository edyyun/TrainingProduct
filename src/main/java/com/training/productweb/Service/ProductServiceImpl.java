package com.training.productweb.Service;

import com.training.productweb.Entity.Product;
import com.training.productweb.Repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository ;

    @Override
    public Product create(Product product) {
        if(product.getCategoryId()==0||
        product.getProductDesc()==null||
        product.getProductId()==0||
        product.getProductName()==null||
        product.getProductPrice()==0||
        product.getProductQty()==0)return null;

        productRepository.save(product);
        return product;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }else
            return null;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product,Long id) {
        product.setProductId(id);
        productRepository.save(product);
        return product;

    }

    @Override
    public Product delete(Long id) {
        productRepository.delete(findById(id));
        return  findById(id);
    }
}

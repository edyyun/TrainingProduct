package com.training.productweb.Service;

import com.training.productweb.Model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductServiceImpl implements ProductService {

    private ArrayList<Product> products=new ArrayList<>();

    @Override
    public Product create(Product product) {
        if(product.getCategoryId()==0||
        product.getProductDesc()==null||
        product.getProductId()==0||
        product.getProductName()==null||
        product.getProductPrice()==0||
        product.getProductQty()==0)return null;

        if(findById(product.getCategoryId())==null)
        {
            products.add(product);
            return product;
        }else
        return null;
    }

    @Override
    public Product findById(int id) {
        for (Product a:products) {
            if(a.getProductId()==id)return a;
        }
        return null;
    }

    @Override
    public ArrayList<Product> findAll() {
        return products;
    }

    @Override
    public Product update(Product product) {
        if(product.getCategoryId()==0||
                product.getProductDesc()==null||
                product.getProductId()==0||
                product.getProductName()==null||
                product.getProductPrice()==0||
                product.getProductQty()==0)return null;
        Product a = findById(product.getProductId());
        if(a==null)
            return null;
        else{
            BeanUtils.copyProperties(product,a);
            return product;
        }
    }

    @Override
    public Product delete(int id) {
        if(id==0)return null;
        Product a = findById(id);
        if(a==null){
            return null;
        }else{
            products.remove(a);
            return a;
        }
    }
}

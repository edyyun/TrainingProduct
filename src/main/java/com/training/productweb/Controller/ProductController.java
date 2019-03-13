package com.training.productweb.Controller;

import com.training.productweb.Entity.ApiKey;
import com.training.productweb.Entity.Product;
import com.training.productweb.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            value = "/product",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }
    @RequestMapping(
            value = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> findAll(ApiKey apiKey){
        return productService.findAll();
    }
    @RequestMapping(
            value = "/products/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findById(@PathVariable("id")Long id){
        return productService.findById(id);
    }
    @RequestMapping(
            value = "/products/update/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody Product product, @PathVariable("id")Long id) {
        return productService.update(product, id);
    }
    @RequestMapping(
            value = "/products/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable("id") Long id){
        return productService.delete(id);
    }
}

package com.training.productweb.Controller;

import com.training.productweb.Model.Product;
import com.training.productweb.Service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {

    private ProductService productService ;

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
    public ArrayList<Product> findAll(){
        return productService.findAll();
    }
    @RequestMapping(
            value = "/products/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findById(@PathVariable("id")int id){
        return productService.findById(id);
    }
    @RequestMapping(
            value = "/products/update/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody Product product, @PathVariable("id")int id) {
        return productService.update(product);
    }
    @RequestMapping(
            value = "/products/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable("id") int id){
        return productService.delete(id);
    }
}

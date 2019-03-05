package com.training.productweb.Service;

import com.training.productweb.Model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductServiceTest {

    private ProductService service;

    @Before
    public void setUp() throws Exception {
        service=new ProductServiceImpl();
    }
    @Test
    public void CreateTest(){
        Product a = new Product(1,"Roka",2000,3,"Coklat bulat",1);
        service.create(a);
        Assert.assertTrue(service.findAll().size()==1);
        Assert.assertTrue(service.findById(1)==a);
        a = new Product();
        Assert.assertTrue(service.create(a)==null);
    }
    @Test
    public void FindByIdTest(){
        Product a = new Product(1,"Roka",2000,3,"Coklat bulat",1);
        service.create(a);
        service.create(new Product(2,"Indomilk",5000,6,"Susu Full Cream",2));
        service.create(new Product(3,null,0,3,"Coklat bulat",1));
        Assert.assertTrue(service.findById(1)==a);
    }
    @Test
    public void FindAllTest(){
        service.create(new Product(1,"Roka",2000,3,"Coklat bulat",1));
        service.create(new Product(2,"Indomilk",5000,6,"Susu Full Cream",2));
        service.create(new Product(3,null,0,3,"Coklat bulat",1));
        Assert.assertTrue(service.findAll().size()==2);
    }
    @Test
    public void UpdateTest(){
        Product a = new Product(1,"Roka",2000,3,"Coklat bulat",1);
        service.create(a);
        Product b= new Product(1,"Roka",6000,7,"Coklat bulat",1);
        Product c= service.update(b);
        Assert.assertTrue(c!=null);
        Assert.assertTrue(c==b);
    }

    @Test
    public void DeleteTest(){
        service.create(new Product(1,"Roka",2000,3,"Coklat bulat",1));
        service.create(new Product(2,"Indomilk",5000,6,"Susu Full Cream",2));
        Assert.assertTrue(service.delete(3)==null);
        Assert.assertTrue(service.findById(1)==service.delete(1));
    }
}

package com.training.productweb.Service;

import com.training.productweb.Entity.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    private ProductService service;

    @Before
    public void setUp() throws Exception {
        service=new ProductServiceImpl();
    }
    @Test
    public void CreateTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        service.create(a);
        Assert.assertTrue(service.findById(a.getProductId())==a);
        a = new Product();
        Assert.assertTrue(service.create(a)==null);
    }
    @Test
    public void FindByIdTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        service.create(a);

        Assert.assertTrue(service.findById(a.getProductId())==a);
    }
    @Test
    public void FindAllTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        service.create(a);

        Product b = new Product();
        b.setCategoryId(2L);
        b.setProductDesc("Susu sehat");
        b.setProductName("Indomilk");
        b.setProductPrice(5000);
        b.setProductQty(8);
        service.create(b);

        Assert.assertTrue(service.findAll().size()==2);
    }
    @Test
    public void UpdateTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        service.create(a);

        Product b = new Product();
        b.setCategoryId(2L);
        b.setProductDesc("Susu sehat");
        b.setProductName("Indomilk");
        b.setProductPrice(5000);
        b.setProductQty(8);
        Product c= service.update(b,b.getProductId());
        Assert.assertTrue(c!=null);
        Assert.assertTrue(c==b);
    }

    @Test
    public void DeleteTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        service.create(a);

        Product b = new Product();
        b.setCategoryId(2L);
        b.setProductDesc("Susu sehat");
        b.setProductName("Indomilk");
        b.setProductPrice(5000);
        b.setProductQty(8);
        service.create(b);
        Assert.assertTrue(service.delete(3L)==null);
        Assert.assertTrue(service.findById(1L)==service.delete(1L));
    }
}

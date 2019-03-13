package com.training.productweb.Service;

import com.training.productweb.Entity.Product;
import com.training.productweb.Repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    private ProductService service;
    private ProductRepository repo;
    @Before
    public void setUp() throws Exception {
        repo = Mockito.mock(ProductRepository.class);
        service=new ProductServiceImpl(repo);

    }
    @Test
    public void CreateTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        Mockito.when(repo.save(a)).thenReturn(a);
        Product b = service.create(a);
        Assert.assertTrue(b!=null);
        Assert.assertTrue(a.getProductId()==b.getProductId());
    }
    @Test
    public void FindByIdTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(a));
        Mockito.when(repo.findById(2L)).thenReturn(Optional.empty());
        Mockito.when(repo.save(a)).thenReturn(a);
        service.create(a);

        Product pro1=service.findById(1L);
        Assert.assertTrue(pro1!=null);
        pro1=service.findById(2L);
        Assert.assertTrue(pro1==null);

    }
    @Test
    public void FindAllTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        Mockito.when(repo.save(a)).thenReturn(a);
        service.create(a);

        Product b = new Product();
        b.setCategoryId(2L);
        b.setProductDesc("Susu sehat");
        b.setProductName("Indomilk");
        b.setProductPrice(5000);
        b.setProductQty(8);
        service.create(b);
        List<Product> products = null;
        Mockito.when(repo.findAll()).thenReturn(products);
        Assert.assertTrue(service.findAll()==null);
    }
    @Test
    public void UpdateTest(){
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        Mockito.when(repo.save(a)).thenReturn(a);
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
        Mockito.when(repo.save(a)).thenReturn(a);
        service.create(a);

        Product b = new Product();
        b.setCategoryId(2L);
        b.setProductDesc("Susu sehat");
        b.setProductName("Indomilk");
        b.setProductPrice(5000);
        b.setProductQty(8);
        service.create(b);
        service.delete(3L);
        service.delete(1L);
        List<Product> products =null;
        Mockito.when(repo.findAll()).thenReturn(products);
        Assert.assertTrue(service.findAll() == null);
    }
}

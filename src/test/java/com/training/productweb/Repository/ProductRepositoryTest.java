package com.training.productweb.Repository;

import com.training.productweb.Entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository ;

    @Test
    public void testRepository(){
        Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);
        Product a = new Product();
        a.setCategoryId(1L);
        a.setProductDesc("Coklat bulat");
        a.setProductName("Roka");
        a.setProductPrice(2000);
        a.setProductQty(3);
        //save or update
        productRepository.save(a);
        a.setProductName("Minuman");
        productRepository.save(a);

        //findAll
        List<Product> list = productRepository.findAll();
        logger.info(list.toString());
        //delete
        productRepository.delete(a);
        list = productRepository.findAll();
        logger.info(list.toString());

    }
}

package com.example.ProductModule;

import com.example.ProductModule.DAO.CategoryDAO;
import com.example.ProductModule.DAO.ProductDAO;
import com.example.ProductModule.Models.Product;
import com.example.ProductModule.Models.ProductCategory;
import com.example.ProductModule.Repository.CategoryRepository;
import com.example.ProductModule.Repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    @Autowired
        CategoryDAO categoryDAO;
    @Autowired
        ProductDAO productDAO;


    @Override
    public void run(String... args) throws Exception {


            ProductCategory productCategory1=new ProductCategory();
            productCategory1.setId(1);
            productCategory1.setCategoryName("meyve");

            ProductCategory productCategory2=new ProductCategory();
            productCategory2.setId(2);
            productCategory2.setCategoryName("sebze");

            ProductCategory productCategory3=new ProductCategory();
            productCategory3.setId(3);
            productCategory3.setCategoryName("icecek");

            Product product1=new Product();
            product1.setId(1);
            product1.setName("armut");
            product1.setPrice(8);
            product1.setCategoryId(1);


            Product product2=new Product();
            product2.setId(2);
            product2.setName("kivi");
            product2.setPrice(12);
            product2.setCategoryId(1);


            Product product3=new Product();
            product3.setId(3);
            product3.setName("domates");
            product3.setPrice(25);
            product3.setCategoryId(3);

            Product product4=new Product();
            product4.setId(4);
            product4.setName("brokoli");
            product4.setPrice(60);
            product4.setCategoryId(2);

            Product product5=new Product();
            product5.setId(5);
            product5.setName("fasulye");
            product5.setPrice(25);
            product5.setCategoryId(3);

            Product product6=new Product();
            product6.setId(6);
            product6.setName("muz");
            product6.setPrice(78);
            product6.setCategoryId(1);

            Product product7=new Product();
            product7.setId(7);
            product7.setName("domates");
            product7.setPrice(12);
            product7.setCategoryId(2);

                categoryDAO.Add(productCategory1);
                categoryDAO.Add(productCategory2);
                categoryDAO.Add(productCategory3);

                productDAO.Add(product1);
                productDAO.Add(product2);
                productDAO.Add(product3);

    }
}

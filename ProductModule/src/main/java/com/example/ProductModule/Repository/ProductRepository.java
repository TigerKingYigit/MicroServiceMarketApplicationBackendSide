package com.example.ProductModule.Repository;

import com.example.ProductModule.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    /**
    * to get product from database by name*
    * @param productName String type of field in product class
    * */
    Product findByName(String productName);

}

package com.example.ProductModule.Service.ProductService;

import com.example.ProductModule.Models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> GetListByFirstLetter(char letter);
    List<Product> GetListProduct();
    void AddProduct(Product product);
    List<Product> getAllProductsBySorting(String field);
    List<Product> getAllProductsWithPagination(int no, int size);
    Product getProductByName(String productName);
    Optional<Product> getProductById(int productId);
    void softDeleteProduct(int id);
}


package com.example.ProductModule.Service.ProductService;

import com.example.ProductModule.DAO.ProductDAO;
import com.example.ProductModule.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//pagination,sorting,filter
@Service
public class ProductService implements IProductService {
    public List<Product> productList = new ArrayList<Product>();

    private final ProductDAO productDAO;
    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    /**
     * to get product list  by their first letter
     * @param letter which letter we want product's name start with
     * */
    public List<Product> GetListByFirstLetter(char letter)
    {
        return productDAO.getListByFirstLetter(letter);
    }
    /**
     * to get product list
     * */
    public List<Product> GetListProduct()
    {
        return productDAO.GetList();
    }
    /**
     * to add product to database
     * @param product we want to add
     * */
    public void AddProduct(Product product){
        productDAO.Add(product);
    }
    /**
     *to sort products
     * @param field which field we want to sort
     * */
    public List<Product> getAllProductsBySorting(String field) {
        return productDAO.getAllProductsBySorting(field);
    }
    /**
     *to paginate product list
     * @param no which page number we want to be in
     * @param size how many element we want a page to contain
     * */
    public List<Product> getAllProductsWithPagination(int no,int size) {
        return productDAO.getAllProductsWithPagination(no,size);
    }

    public Product getProductByName(String productName) {
        return productDAO.getProductByName(productName);
    }

    public Optional<Product> getProductById(int productId) {
        return productDAO.GetById(productId);
    }

    public void softDeleteProduct(int id){
        productDAO.setIsDeletedTrue(id);
    }
}

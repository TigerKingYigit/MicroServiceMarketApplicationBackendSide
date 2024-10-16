package com.example.ProductModule.DAO;


import com.example.ProductModule.Models.Product;
import com.example.ProductModule.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductDAO implements IProductDAO {

    @Autowired
    private ProductRepository productRepository;
    @Override
    @Transactional
    /**
     * to get product list from database
     * */
    public List<Product> GetList() {
        List<Product> s = productRepository.findAll();
        return s;
    }
    /**
     * to add product to database
     * @param Entity product
     * */
    @Override
    public void Add(Product Entity) {
        productRepository.save(Entity);
    }
    /**
     * to delete product by id
     * @param Id product's primary key
     * */

    @Override
    public void setIsDeletedTrue(Integer Id) {
        Optional<Product> product=productRepository.findById(Id);
        product.get().setDeleted(true);
        productRepository.save(product.get());
    }
    /**
     * to make modifications for product
     * @param Entity product
     * */
    @Override
    public void Update(Product Entity) {

    }
    /**
     * to get product by id
     * @param Id product's primary key
     * */
    @Override
    public Optional<Product> GetById(Integer Id) {
        return productRepository.findById(Id);

    }
    /**
     *to get product by name
     * @param productName to search product according to its name
     * */

    public Product getProductByName(String productName){
        Product product= productRepository.findByName(productName);
        return Optional.ofNullable(product)
                .orElseThrow(()->new RuntimeException("The product you are calling for could not be found !"));
    }
    /**
     * to sort all products by field we choose
     * @param field which product field we want to sort products
     * */
    public List<Product> getAllProductsBySorting(String field) {
        List<Product> productList =
                productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
        return productList;
    }
    /**
     * to paginate all products
     * @param no which page we want to be in
     * @param size how many object we want a page to contain
     * */
    public List<Product> getAllProductsWithPagination(int no, int size) {
        Pageable pageable = PageRequest.of(no,size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return  productPage.toList();
    }
    /**
     * to get product list according to its first letter
     * @param letter which letter we want a word begin with it
     * */
    public List<Product> getListByFirstLetter(char letter) {
        List<Product> products= productRepository.findAll();
        return products.stream().filter(
                p->Character.toLowerCase(p.getName().charAt(0))==
                        Character.toLowerCase(letter)).collect(Collectors.toList());

    }

//    public List<Product> getProductsBySaleId(int saleId) {
//        List<Product> products=productRepository.findAll();
//        return products.stream().filter(
//                p->p.getSaleId().equals(saleId)
//        ).collect(Collectors.toList());
//    }
}

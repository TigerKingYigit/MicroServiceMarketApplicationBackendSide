package com.example.ProductModule.DAO;

import com.example.ProductModule.Repository.CategoryRepository;
import com.example.ProductModule.Repository.GenericRepository;
import com.example.ProductModule.Models.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDAO extends ICategoryDAO implements GenericRepository<ProductCategory> {
    @Autowired
    private CategoryRepository categoryRepository;
    /**
     * to add product category to database
     * @param  Entity product category
     * */

    @Override
    public void Add(ProductCategory Entity) {
        categoryRepository.save(Entity);
    }
    /**
     *  to delete category from database by id
     * @param Id category's id
     * */
    @Override
    public void setIsDeletedTrue(Integer Id) {

    }
    /**
     * to make modifications product category in database
     * @param Entity product category
     * */
    @Override
    public void Update(ProductCategory Entity) {

    }
    /**
     * to get product category by id
     * @param Id product category's Id
     * */
    @Override
    public Optional<ProductCategory> GetById(Integer Id) {
        return categoryRepository.findById(Id);
    }
    /**
     * to get list of product categories
     * */
    @Override
    public List<ProductCategory> GetList() {
        return categoryRepository.findAll();
    }
}

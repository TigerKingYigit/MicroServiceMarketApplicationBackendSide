package com.example.ProductModule.Service.CategoryService;

import com.example.ProductModule.DAO.CategoryDAO;
import com.example.ProductModule.Models.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryService extends ICategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public Optional<ProductCategory> getProductCategory(int id){
        return categoryDAO.GetById(id);
    }
}

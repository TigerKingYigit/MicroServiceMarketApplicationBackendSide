package com.example.ProductModule.Controller;

import com.example.ProductModule.Models.ProductCategory;
import com.example.ProductModule.Service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/management")
@PreAuthorize("hasRole('CASHIER')")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("getCategoryById/{id}")
    public Optional<ProductCategory> getproductCategoryById(@PathVariable int id){
        Optional<ProductCategory> productCategory= categoryService.getProductCategory(id);
        return productCategory;
    }

}

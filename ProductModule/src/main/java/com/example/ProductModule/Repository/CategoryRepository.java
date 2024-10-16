package com.example.ProductModule.Repository;

import com.example.ProductModule.Models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<ProductCategory,Integer> {
}

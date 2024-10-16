package com.example.SaleModule.Repository;

import com.example.SaleModule.Models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
    public List<Sale> getSalesBySellingNumber(int sellingNumber);
}

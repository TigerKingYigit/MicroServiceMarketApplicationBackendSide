package com.example.SaleModule.SaleService;

import com.example.SaleModule.Models.Sale;
import com.example.SaleModule.Models.SaleDTOGet;
import com.example.SaleModule.Models.SaleDTOSet;

import java.util.List;

public interface ISaleService {
    void deleteSaleById(Integer id);
    void updateSale(Sale sale);
    List<SaleDTOGet> getSaleDTOByProductId(int productId);
    void sale(List<SaleDTOSet> saleDTOs);
    public List<Sale> getSaleList();
    List<Sale> getSaleByNumber(int sellingNumber);
    void softDeleteSaleById(int id);
}
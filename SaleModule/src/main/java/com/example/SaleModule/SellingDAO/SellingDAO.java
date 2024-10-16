package com.example.SaleModule.SellingDAO;

import com.example.SaleModule.Repository.GenericRepository;
import com.example.SaleModule.Models.Sale;
import com.example.SaleModule.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SellingDAO implements GenericRepository<Sale>,ISellingDAO {
    @Autowired
    public SaleRepository saleRepository;
    /**
     *to add sale to database
     * @param Entity sale object
     * */
    @Override
    public void Add(Sale Entity) {
        saleRepository.save(Entity);
    }
    /**
     * to delete sale by id
     * @param Id sale's primary key
     * */
    @Override
    public void DeleteById(Integer Id) {
        saleRepository.deleteById(Id);
    }
    /**
     *to make modifications for sale
     * @param Entity sale object
     * */
    @Override
    public void Update(Sale Entity) {
        saleRepository.save(Entity);
    }
    /**
     * to get sale by id
     * @param Id sale's primary key
     * */
    @Override
    public Optional<Sale> GetById(Integer Id) {
        return saleRepository.findById(Id);
    }
    /**
     * to get sale list
     * */
    @Override
    public List<Sale> GetList() {
        return saleRepository.findAll();
    }
    /**
     * to get sale list by sale's product id
     * @param productId sale's product id
     * */
    public List<Sale> getSaleByProductId(int productId){
        List<Sale> sales= saleRepository.findAll();
        List<Sale> filteredSales= sales.stream().filter(
                sale -> sale.getProductId().equals(productId)
        ).collect(Collectors.toList());
        System.out.println(filteredSales);
        return filteredSales;
    }
    /**
     * to get sale list by number
     * @param number sale number
     * */
    public List<Sale> getSaleByNumber(int number){
        List<Sale> sales= saleRepository.findAll();
        List<Sale> filteredSales =sales.stream().filter(
                sale->sale.getSellingNumber()==number
        ).toList();
        return filteredSales;
    }

    public void softDeleteSaleById(int id) {
        Optional<Sale> sale = saleRepository.findById(id);
        sale.get().setDeleted(true);
        saleRepository.save(sale.get());
    }
}

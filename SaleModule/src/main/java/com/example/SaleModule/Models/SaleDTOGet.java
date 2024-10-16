package com.example.SaleModule.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SaleDTOGet {
    private int sellingNumber;
    private Date date;  // i will be back here
    private float totalPrice;
    private float totalPriceWithKdv;
    private float kdv;
    private List<String> namesOfProductsSold = new ArrayList<String>();
    private int quantity;
    private String appliedOffer;
    private String category;
    private boolean isDeleted=false;
    /**
     * to increase total quantity which user how many buys
     * @param quantity how many ones user buys
     * */
    public void increaseTotalQuantity(int quantity){
        this.quantity+=quantity;
    }
    /**
     * find the product by productname then add it to the list
     * @param productName the product we are looking for
     * */
    public void addList(String productName){// i will delete this method later
        this.namesOfProductsSold.add(productName);
    }
    /**
     *  to sum price and our total price
     * @param price product's price
     * */
    public void increaseTotalPrice(float price){
        this.totalPrice+=price;
    }
    /**
     * to calculate total price by adding kdv
     * @param price product's price
     * */
    public void increaseTotalPriceWithKdv(float price){
        this.totalPriceWithKdv+=price;
    }
}
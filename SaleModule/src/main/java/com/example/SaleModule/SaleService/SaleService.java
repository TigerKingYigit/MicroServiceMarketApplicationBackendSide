package com.example.SaleModule.SaleService;

import com.example.SaleModule.Models.*;
import com.example.SaleModule.OfferDAO.OfferDAO;
import com.example.SaleModule.ProductServiceClient;
import com.example.SaleModule.SellingDAO.SellingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Service
public class SaleService implements ISaleService {
    List<SaleDTOGet> saleDTOGets = new ArrayList<SaleDTOGet>();
    Random random = new Random();
    @Autowired
    private SellingDAO sellingDAO;
    @Autowired
    private ProductServiceClient productServiceClient;
    @Autowired
    public OfferDAO offerDAO;

    public void deleteSaleById(Integer id) {
        sellingDAO.DeleteById(id);
    }

    public void updateSale(Sale sale) {
        sellingDAO.Update(sale);
    }
    //to know which product how many ones sold

    /**
     * to get saleDTOGet list by sale's product id
     */
    public List<SaleDTOGet> getSaleDTOByProductId(int productId) {
        List<Sale> sales = sellingDAO.getSaleByProductId(productId);
        for (Sale sale : sales) {
            SaleDTOGet saleDTOGet = new SaleDTOGet();
            saleDTOGet.setKdv(0.8F);
            Product product = productServiceClient.getProductById(sale.getProductId());
            saleDTOGet.increaseTotalPrice(product.getPrice() * sale.getQuantity());
            saleDTOGet.setTotalPriceWithKdv(
                    product.getPrice() * sale.getQuantity() +
                            (product.getPrice() * sale.getQuantity()) * saleDTOGet.getKdv()
            );
            //saleDTOGet.setNameOfProductSold(sale.getProduct().getName());
            saleDTOGet.addList(product.getName());
            saleDTOGet.setQuantity(sale.getQuantity());
            //  saleDTOGet.setAppliedOffer(sale.getOffer().getOfferName());
            ProductCategory category = productServiceClient.getCategoryById(product.getCategoryId());
            saleDTOGet.setCategory(category.getCategoryName());
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            saleDTOGet.setDate(timestamp);
            saleDTOGets.add(saleDTOGet);
        }
        return saleDTOGets;
    }

    /**
     * to add sale to database
     *
     * @param saleDTOs th object we sent as json object from postman
     */
    public void sale(List<SaleDTOSet> saleDTOs) {
        int number = random.nextInt(10000);
        for (SaleDTOSet saleDTO : saleDTOs) {
            Product product = productServiceClient.getProductByName(saleDTO.getProductName());
            Sale sale = new Sale();
            sale.setPayingType(saleDTO.getPayingType());
            sale.setSellingNumber(number);
            int quantity = saleDTO.getQuantity();
            float price = product.getPrice();
            float kdv = 0.8F;
            List<Offer> offers = offerDAO.GetList();
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());//offer operations
            for (Offer ofr : offers) {
                if (timestamp.after(ofr.getStartingDate()) && timestamp.before(ofr.getEndingDate())) {
                    sale.setOfferId(ofr.getId());
                    Offer offer = ofr;
                    float discount = price * offer.getDiscountRate() / 100;
                    price = price - discount;
                }
            }
            sale.setDate(timestamp);
            sale.setProductId(product.getId());
            sale.setQuantity(quantity);
            sellingDAO.Add(sale);
        }
    }

    public List<Sale> getSaleList() {
        return sellingDAO.GetList();
    }

    public List<Sale> getSaleByNumber(int sellingNumber) {
        return sellingDAO.getSaleByNumber(sellingNumber);
    }

    public void softDeleteSaleById(int id) {
        sellingDAO.softDeleteSaleById(id);
    }
}
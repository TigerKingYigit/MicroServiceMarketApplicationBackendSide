package com.example.SaleModule.Controller;
import com.example.SaleModule.Models.*;
import com.example.SaleModule.OfferService.OfferService;
import com.example.SaleModule.ProductServiceClient;
import com.example.SaleModule.SaleService.ISaleService;
import com.example.SaleModule.SaleService.SaleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//for offers, pagination,sorting and filtering
@RestController
@RequestMapping("saleApi")
//@PreAuthorize("hasRole('ADMIN')")
public class SaleController {
    private static final Logger logger = LogManager.getLogger(SaleController.class);
   private final ISaleService saleService;
   SaleController(SaleService saleService){
       this.saleService=saleService;
   }
    @Autowired
    private OfferService offerService;
    @Autowired
    private ProductServiceClient productServiceClient;
    @RequestMapping("getProductList")
    public List<Product> getProductList() {
        logger.info("All products are on the screen !");
          return productServiceClient.getProductList();
    }
    @RequestMapping("getProductById/{productId}")
    public Product getProductById(@PathVariable int productId){
        logger.info("the products is brought by its id");
        Product product= productServiceClient.getProductById(productId);
        return product;
    }
    @PostMapping("sale")
    public void sale(@RequestBody List<SaleDTOSet> saleDTOSet){
        logger.info("sale is done !");
        saleService.sale(saleDTOSet);

    }
    @GetMapping("getSaleDTOByProductId/{id}")
    public List<SaleDTOGet> getSales(@PathVariable int id){
        logger.info("SaleDTO is brought by their product id");
        return saleService.getSaleDTOByProductId(id);
    };
    @GetMapping("getOffersWithSorting/{field}")
    public List<Offer> getOffersWithSorting(@PathVariable String field){
        logger.info("All offers are brught according the field we want to sort");
        return offerService.getOffersWithSorting(field);
    }
    @GetMapping("getAllOffersWithPagination/{pageNumber}/{pageSize}")
    public List<Offer> getAllOffersWithPagination(@PathVariable int pageNumber,
                                                  @PathVariable int pageSize){
        logger.info("All offers are brought in pagination");
        return offerService.getAllOffersWithPagination(pageNumber,pageSize);
    }
    @GetMapping("getOfferListByFirstLetter/{letter}")
    public List<Offer> getOfferListByFirstLetter(@PathVariable char letter){
        logger.info("all offers are brought according to letter we want to see");
        return offerService.getOfferListByFirstLetter(letter);
    }
    @GetMapping("getSaleList")
    public List<Sale> getSaleList(){
        logger.info("All sales are brought");
        return saleService.getSaleList();
    }
    @GetMapping("getOfferById/{offerId}")
    public Optional<Offer> getOfferById(@PathVariable int offerId){
        logger.info("Offer is on the screen according to id");
        return offerService.getOfferById(offerId);
    }
    @GetMapping("getSaleByNumber/{sellingNumber}")
    public List<Sale> getSaleByNumber(@PathVariable int sellingNumber){
        logger.info("Sale is brought by its number");
        return saleService.getSaleByNumber(sellingNumber);
    }
    @GetMapping("softDeleteSaleById/{id}")
    public void softDeleteSaleById(@PathVariable int id){
        logger.info("Sale is markes as deleted");
        saleService.softDeleteSaleById(id);
    }
}
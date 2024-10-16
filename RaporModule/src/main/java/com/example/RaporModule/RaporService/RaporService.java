package com.example.RaporModule.RaporService;

import com.example.RaporModule.Models.Offer;
import com.example.RaporModule.Models.Product;
import com.example.RaporModule.Models.Sale;
import com.example.RaporModule.Models.SaleDTOGet;

import com.example.RaporModule.PDFGeneratorService.PDFGeneratorService;
import com.example.RaporModule.ProductServiceClient;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

// only store manager can do this operation
// filter the all sales
// create a pdf type of fis
@Service
public class RaporService implements IRaporService {
    @Autowired
    ProductServiceClient productServiceClient;
    @Autowired
    private PDFGeneratorService pdfGeneratorService;
    List<SaleDTOGet> saleDTOGets = new ArrayList<SaleDTOGet>();

    /**
     * to get SaleDtoGet List by using sale object from database
     */
    public List<SaleDTOGet> getSaleDToListAll() {
        List<Sale> sales = productServiceClient.getSaleList();
        SaleDTOGet saleDTOGet = new SaleDTOGet();
        int number = sales.get(0).getSellingNumber();

        for (Sale sale : sales) {
            if (sale.getSellingNumber() != number) {
                saleDTOGets.add(saleDTOGet);
                saleDTOGet = new SaleDTOGet();
                saleDTOGet.setKdv(0.08F);
            }

            List<Product> products = productServiceClient.getProductsById(sale.getProductId());
            for (Product product : products) {
                saleDTOGet.increaseTotalPrice(product.getPrice() * sale.getQuantity());
                saleDTOGet.increaseTotalPriceWithKdv(
                        product.getPrice() * sale.getQuantity() +
                                (product.getPrice() * sale.getQuantity()) * saleDTOGet.getKdv()
                );
                saleDTOGet.getNamesOfProductsSold().add(product.getName());
            }
            saleDTOGet.setKdv(0.08F);
            saleDTOGet.setSellingNumber(sale.getSellingNumber());
            saleDTOGet.setDate(sale.getDate());
            saleDTOGet.increaseTotalQuantity(sale.getQuantity());
            Offer offer=productServiceClient.getOfferById(sale.getOfferId());
            saleDTOGet.setAppliedOffer(offer.getOfferName());
            number = sale.getSellingNumber();
        }
        saleDTOGets.add(saleDTOGet);
        return saleDTOGets;
    }

    /**
     * to get detailed PDF of saleDTO object by its number
     *
     * @param sellingNumber which sale we want to see
     * @param response      system's response for PDF
     * @throws FileNotFoundException it throws exceptions if file not found
     */
    public SaleDTOGet getSaleDTOByNumber(int sellingNumber,
                                         HttpServletRequest response)
            throws FileNotFoundException {
        List<Sale> sales = productServiceClient.getSalesByNumber(sellingNumber);
        SaleDTOGet saleDTOGet = new SaleDTOGet();
        int number = sales.get(0).getSellingNumber();
System.out.println(number);
        for (Sale sale : sales) {
            if (sale.getSellingNumber() != number) {
                saleDTOGets.add(saleDTOGet);
                saleDTOGet = new SaleDTOGet();
                saleDTOGet.setKdv(0.08F);
                List<Product> products = productServiceClient.getProductsById(sale.getId());
                for (Product product : products) {
                    saleDTOGet.increaseTotalPrice(product.getPrice() * sale.getQuantity());
                    saleDTOGet.increaseTotalPriceWithKdv(
                            product.getPrice() * sale.getQuantity() +
                                    (product.getPrice() * sale.getQuantity()) * saleDTOGet.getKdv()
                    );
                    saleDTOGet.getNamesOfProductsSold().add(product.getName());
                }
                saleDTOGet.setSellingNumber(sale.getSellingNumber());


                saleDTOGet.increaseTotalQuantity(sale.getQuantity());
                // saleDTOGet.setAppliedOffer(sale.getOffer().getOfferName());
                number = sale.getSellingNumber();
            }


            pdfGeneratorService.export(response, saleDTOGet, sales);
        }
        return saleDTOGet;
    }
}
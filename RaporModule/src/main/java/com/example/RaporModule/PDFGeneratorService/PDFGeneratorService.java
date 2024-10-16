package com.example.RaporModule.PDFGeneratorService;


import com.example.RaporModule.Models.Product;
import com.example.RaporModule.Models.Sale;
import com.example.RaporModule.Models.SaleDTOGet;
import com.example.RaporModule.ProductServiceClient;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;


@Service
public class PDFGeneratorService {
    @Autowired
    private ProductServiceClient productServiceClient;

    /**
     * to create a pdf page
     *
     * @param response   the answer system give
     * @param saleDTOGet dto object for sale
     * @param sales
     * @throws IOException
     */
    public void export(HttpServletRequest response, SaleDTOGet saleDTOGet, List<Sale> sales) throws IOException, FileNotFoundException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("FischExample.pdf"));
        document.open();
        for (Sale sl:sales){
            Product product=productServiceClient.getProductBySaleId(sl.getId());
            document.add(new Paragraph("Satılan ürün:" + product.getName()));
            document.add(new Paragraph("Satılan adet sayısı: " + sl.getQuantity()));
        }
        document.add(new Paragraph("Uygulanan KDV:"+saleDTOGet.getKdv()));
        document.add(new Paragraph("Satılan Adet Sayısı:"+"X"+saleDTOGet.getQuantity()));
        document.add(new Paragraph("KDV'siz Toplam Tutar:"+saleDTOGet.getTotalPrice()));
        document.add(new Paragraph("KDV'li Toplam Tutar:"+saleDTOGet.getTotalPriceWithKdv()));
//        if (saleDTOGet.getAppliedOffer()!=null){
//            document.add(new Paragraph("Uygulanan Kampanya:"+saleDTOGet.getAppliedOffer()));
//            document.add(new Paragraph("Net Ücret:"+saleDTOGet.getTotalPriceWithKdv()));
//        }
        document.add(new Paragraph("Uygulanan Kampanya: Kampanya uygulanmamıştır"));
        document.add(new Paragraph("Net Ücret:"+saleDTOGet.getTotalPriceWithKdv()));
        document.close();
    }
}
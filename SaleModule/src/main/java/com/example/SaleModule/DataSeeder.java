package com.example.SaleModule;

import com.example.SaleModule.Models.Offer;
import com.example.SaleModule.Repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DataSeeder implements CommandLineRunner {
    @Autowired
    OfferRepository offerRepository;
    @Override
    public void run(String... args) throws Exception {
        Offer offer = new Offer();
        offer.setId(1);
        offer.setOfferName("Spring Sale");
        offer.setStartingDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        offer.setEndingDate(Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant())); // Ending date 1 day from now
        offer.setDiscountRate(20); // 20% discount

        Offer offer2 = new Offer();
        offer2.setId(2);
        offer2.setOfferName("Summer Clearance");
        offer2.setStartingDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        offer2.setEndingDate(Date.from(LocalDateTime.now().plusDays(7).atZone(ZoneId.systemDefault()).toInstant())); // Ending date 7 days from now
        offer2.setDiscountRate(30); // 30% discount

        offerRepository.save(offer);
        offerRepository.save(offer2);
    }
}

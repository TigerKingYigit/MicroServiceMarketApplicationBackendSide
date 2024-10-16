package com.example.SaleModule.Repository;

import com.example.SaleModule.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer,Integer> {
}

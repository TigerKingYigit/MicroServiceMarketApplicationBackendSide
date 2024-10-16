package com.example.SaleModule.OfferService;

import com.example.SaleModule.Models.Offer;
import com.example.SaleModule.OfferDAO.OfferDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService implements IOfferService{
    @Autowired
    private OfferDAO offerDAO;
    /**
     * to get offer list by sorting
     * @param field which offer field we want to sort
     * */
    public List<Offer> getOffersWithSorting(String field) {
        return offerDAO.getOffersWithSorting(field);
    }

    /**
     * to get offer list by their first letter
     * @param letter which first letter we want to see on the screen
     * */
    public List<Offer> getOfferListByFirstLetter(char letter){
        return offerDAO.getOfferListByFirstLetter(letter);
    }
    /**
     * to paginate the offer
     * @param pageNumber which page number we want to get
     * @param pageSize how many object we want a page to contain
     * */
    public List<Offer> getAllOffersWithPagination(int pageNumber,int pageSize){
        return offerDAO.getAllOffersWithPagination(pageNumber,pageSize);
    }
    public Optional<Offer> getOfferById(int id){
        return offerDAO.GetById(id);
    }

    public List<Offer> getOfferList() {
        return offerDAO.GetList();
    }
}

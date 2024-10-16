package com.example.SaleModule.OfferDAO;


import com.example.SaleModule.Repository.GenericRepository;
import com.example.SaleModule.Models.Offer;
import com.example.SaleModule.Repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OfferDAO implements IOfferDAO, GenericRepository<Offer> {
    @Autowired
    private OfferRepository offerRepository;
    /**
     * to add offer to databaes
     * @param Entity offer
     * */
    @Override
    public void Add(Offer Entity) {
        offerRepository.save(Entity);
    }

    /**
     *to delete offer from database by id
     * @param Id offer's primary key
     * */
    @Override
    public void DeleteById(Integer Id) {
        offerRepository.deleteById(Id);
    }

    /**
     *to make modifications about offer
     * @param  Entity offer
     * */
    @Override
    public void Update(Offer Entity) {
        if (Entity!=null){
            offerRepository.save(Entity);
        }
    }
    /**
     * to get offer from database
     * @param Id offer's primary key
     * */
    @Override
    public Optional<Offer> GetById(Integer Id) {
        return offerRepository.findById(Id);
    }
    /**
     * to get offer list from database
     * */
    @Override
    public List<Offer> GetList() {
        return offerRepository.findAll();
    }
    /**
     * to get offer list from database according to their first letter sort
     * @param firstLatter to determine which offer name we want it to be shown
     * */
    public List<Offer> getOffersByFirstLatter(char firstLatter){
        List<Offer> offers = offerRepository.findAll();
        return offers.stream().filter(
                offer->Character.toLowerCase(offer.getOfferName()
                        .charAt(0))==Character.toLowerCase(firstLatter)).collect(Collectors.toList());
    }
    /**
     * to get offer list according to field which we want it to be sorted
     * @param field which offer field we want to make sorting operations
     * */
    public List<Offer> getOffersWithSorting(String field) {
       List<Offer> offerList =
           offerRepository.findAll(Sort.by(Sort.Direction.ASC,field));
        return offerList;
    }
    /**
     * to paginate all offers
     * @param pageNumber which page we want to be in
     * @param pageSize how many element we want a page to contain
     * */
    public List<Offer> getAllOffersWithPagination(int pageNumber,int pageSize){
        Pageable pageable =PageRequest.of(pageNumber,pageSize);
        Page<Offer> offerPage = offerRepository.findAll(pageable);
        return  offerPage.toList();
    }
    /**
     *to get offer list by first letter
     * @param letter which offer's first character we want it to begin with it
     * */
    public  List<Offer> getOfferListByFirstLetter(char letter){
        List<Offer> offers = offerRepository.findAll();
        return offers.stream().filter(
                offer -> Character.toLowerCase(offer.getOfferName().charAt(0))==
                        Character.toLowerCase(letter)).collect(Collectors.toList());
    }
}
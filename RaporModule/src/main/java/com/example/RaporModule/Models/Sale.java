package com.example.RaporModule.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Integer ProductId;
    private int quantity;
    private int sellingNumber;
    private String payingType;

    int offerId;

    private boolean isDeleted=false;
}
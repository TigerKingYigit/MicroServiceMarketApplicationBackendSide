package com.example.RaporModule.RaporService;

import com.example.RaporModule.Models.SaleDTOGet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.FileNotFoundException;
import java.util.List;

public interface IRaporService {

    List<SaleDTOGet> getSaleDToListAll();

    SaleDTOGet getSaleDTOByNumber(int sellingNumber, HttpServletRequest response)
            throws FileNotFoundException;

}

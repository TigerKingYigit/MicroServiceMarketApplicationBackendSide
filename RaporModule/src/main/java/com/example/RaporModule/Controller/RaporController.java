package com.example.RaporModule.Controller;


import com.example.RaporModule.Models.SaleDTOGet;
import com.example.RaporModule.RaporService.IRaporService;
import com.example.RaporModule.RaporService.RaporService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
//8085
@RestController
@RequestMapping("raporApi")
@PreAuthorize("hasRole('MANAGER')")
public class RaporController {
    private static final Logger logger = LogManager.getLogger(RaporController.class);
    private IRaporService raporService;
    RaporController(RaporService raporService){
        this.raporService=raporService;
    }
    /**
     * to get SaleDTOGet object by using rapor service
     * @param  request  send information to pdf dependecy "burayı duzeltecegim"
     * @param sellingNumber which sale we want it to be shown
     * @throws FileNotFoundException it throws exceptions if file not be found
     * */
    @GetMapping("/getsalebynumber/{sellingNumber}")
    public SaleDTOGet getSaleDTOBySellingNumber(HttpServletRequest request, @PathVariable int sellingNumber) throws FileNotFoundException {
        logger.info("sale is brought according to its number");
        return raporService.getSaleDTOByNumber(sellingNumber,request);
    }
    /**
     * to see detailed sale object on the screen through SaleDTOGet object
     * */
    @GetMapping("/getAllSaleDtoList")
    public List<SaleDTOGet> getAllSaleDtoList(){
        logger.info("All saleDto lists are listed");
        return raporService.getSaleDToListAll();
    }
}

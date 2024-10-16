package com.example.SaleModule;

import com.example.SaleModule.Models.Offer;
import com.example.SaleModule.Models.Product;
import com.example.SaleModule.Models.Sale;
import com.example.SaleModule.Models.SaleDTOSet;
import com.example.SaleModule.OfferDAO.OfferDAO;
import com.example.SaleModule.SaleService.SaleService;
import com.example.SaleModule.SellingDAO.SellingDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class SaleModuleApplicationTests {

//	private SellingDAO sellingDAOMock;
//	private ProductServiceClient productServiceClientMock;
//	private OfferDAO offerDAOMock;
//	private SaleService saleService;
//	@Bean
//	public WebClient.Builder getWebClientBuilder(){
//		return WebClient.builder();
//	}
//	@BeforeEach
//	void setUp() {
//
//		sellingDAOMock = mock(SellingDAO.class);
//		productServiceClientMock = mock(ProductServiceClient.class);
//		offerDAOMock = mock(OfferDAO.class);
//		saleService = new SaleService();
//	}
//
//	@Test
//	void testSale() {
//		// Prepare test data
//		List<SaleDTOSet> saleDTOs = new ArrayList<>();
//		SaleDTOSet saleDTO = new SaleDTOSet();
//		saleDTO.setProductName("Test Product");
//		saleDTO.setPayingType("Credit Card");
//		saleDTO.setQuantity(2);
//		saleDTOs.add(saleDTO);
//
//		Product product = new Product();
//		product.setId(1);
//		product.setName("Test Product");
//		product.setPrice(10.0f);
//		when(productServiceClientMock.getProductByName("Test Product")).thenReturn(product);
//
//		List<Offer> offers = new ArrayList<>();
//		Offer offer = new Offer();
//		offer.setId(1);
//		offer.setDiscountRate(10);
//		offer.setStartingDate(new Timestamp(System.currentTimeMillis() - 1000));
//		offer.setEndingDate(new Timestamp(System.currentTimeMillis() + 1000));
//		offers.add(offer);
//		when(offerDAOMock.GetList()).thenReturn(offers);
//
//		// Call the method under test
//		saleService.sale(saleDTOs);
//
//		// Verify that the sale is added correctly
//		verify(sellingDAOMock, times(1)).Add(any(Sale.class));
//	}
}
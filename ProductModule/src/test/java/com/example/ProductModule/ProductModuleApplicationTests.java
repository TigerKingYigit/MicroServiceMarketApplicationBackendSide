package com.example.ProductModule;

import com.example.ProductModule.DAO.ProductDAO;
import com.example.ProductModule.Models.Product;
import IProductService;
import com.example.ProductModule.Service.ProductService.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProductModuleApplicationTests {
	private ProductDAO productDAOMock;
	private ProductService productService;
	@BeforeEach
	void setUp() {
		productDAOMock = mock(ProductDAO.class);
		productService = new ProductService(productDAOMock);
	}
	@Test
	void contextLoads() {
	}

	@Test
	void testAddProduct() {
		Product product=new Product(140,"Uzum",1,false,1);
		doNothing().when(productDAOMock).Add(product);
		productService.AddProduct(product);
		verify(productDAOMock, times(1)).Add(product);
	}
	@Test
	void testGetAllProductsWithPagination(){
		List<Product> mockProductList = new ArrayList<>();
		mockProductList.add(new Product(140,"Uzum",11,false,1));
		mockProductList.add(new Product(141,"Armut",13,false,2));
		int pageNumber = 1;
		int pageSize = 2;
		when(productDAOMock.getAllProductsWithPagination(pageNumber, pageSize)).thenReturn(mockProductList);
		List<Product> result = productService.getAllProductsWithPagination(pageNumber, pageSize);

		assertEquals(mockProductList.size(), result.size());
		assertEquals(mockProductList.get(0).getName(), result.get(0).getName());
		assertEquals(mockProductList.get(1).getPrice(), result.get(1).getPrice());
	}
}

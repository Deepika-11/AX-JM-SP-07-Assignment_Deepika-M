package com.productmanagementsystem.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.productmanagementsystem.model.Product;
import com.productmanagementsystem.serviceImpl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProductControllerTest {


	@Autowired
	private ProductServiceImpl productServiceImpl;

	@BeforeEach
	void setUp(){
		productServiceImpl.saveProduct(new Product(1,"Boost", LocalDate.now(),"Best Before Six Months"));
		productServiceImpl.saveProduct(new Product(2,"Hoicks", LocalDate.now(),"Best Before Six Months"));
	}

	@Test
	void testSaveProductDetails() {
		boolean ans = productServiceImpl.saveProduct(new Product(3,"Complain", LocalDate.now(),"Best Before Six Months"));
		assertTrue(ans,"Product Details inserted successfully");
	}

	@Test
	void testGetProductById() {
		List<Product> productList = productServiceImpl.getAllProducts();
		assertEquals("Boost", productList.get(0).getProductName());
	}

}

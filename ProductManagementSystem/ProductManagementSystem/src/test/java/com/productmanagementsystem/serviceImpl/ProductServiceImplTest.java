package com.productmanagementsystem.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import com.productmanagementsystem.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class ProductServiceImplTest {

	List<Product> productList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		productList.add(new Product(1,"Boost", LocalDate.now(),"Best Before Six Months"));
		productList.add(new Product(2,"Hoicks", LocalDate.now(),"Best Before Six Months"));
	}

	@Test
	void testGetProductById() {
		assertNotEquals("Boost", productList.get(1).getProductName());
	}

}

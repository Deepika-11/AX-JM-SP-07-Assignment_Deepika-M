package com.productmanagementsystem.controller;


import com.productmanagementsystem.exception.InvalidProductIdException;
import com.productmanagementsystem.model.Product;
import com.productmanagementsystem.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<?> saveProductDetails(@RequestBody Product product) {
        if (!productServiceImpl.saveProduct(product)) {
            return new InvalidProductIdException("Product is already found").handleProductException();
        }
        return new ResponseEntity<>("Product data saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productServiceImpl.getAllProducts();
        System.out.println(products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
        Product product = productServiceImpl.getProductBasedOnId(id);
        if (product == null) {
            return new InvalidProductIdException("Product Id not found").handleProductException();
        }
        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

}
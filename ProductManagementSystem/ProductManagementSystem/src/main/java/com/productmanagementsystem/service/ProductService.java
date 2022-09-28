package com.productmanagementsystem.service;

import com.productmanagementsystem.model.Product;

import java.util.List;

public interface ProductService {

    boolean saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductBasedOnId(int id);



}

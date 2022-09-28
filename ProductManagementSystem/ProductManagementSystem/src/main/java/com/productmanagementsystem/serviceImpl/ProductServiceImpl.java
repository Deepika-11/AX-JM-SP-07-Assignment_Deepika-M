package com.productmanagementsystem.serviceImpl;

import com.productmanagementsystem.model.Product;
import com.productmanagementsystem.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    static List<Product> productList = new ArrayList<>();

    @Override
    public boolean saveProduct(Product product) {
        boolean findId = false;
        for(Product emp : productList){
            if(emp.getProductId() == product.getProductId()){
                findId = true;
            }
        }
        if(!findId){
            productList.add(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product getProductBasedOnId(int id) {
        for(Product emp : productList){
            if(id == emp.getProductId()){
                return emp;
            }
        }
        return null;
    }

}

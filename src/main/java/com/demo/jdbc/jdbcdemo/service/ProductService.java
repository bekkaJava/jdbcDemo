package com.demo.jdbc.jdbcdemo.service;

import com.demo.jdbc.jdbcdemo.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product findById(Integer theId);
    public void deleteById(Integer theId);
    public void save(Product p);
    public void update(Product p);

}

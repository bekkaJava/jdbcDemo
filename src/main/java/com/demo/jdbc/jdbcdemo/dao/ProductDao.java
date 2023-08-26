package com.demo.jdbc.jdbcdemo.dao;

import com.demo.jdbc.jdbcdemo.entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();

    public Product findById(Integer theId);

    public void deleteById(Integer theId);

    public void save(Product p);

    public void update(Product p);
}

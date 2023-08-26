package com.demo.jdbc.jdbcdemo.service;

import com.demo.jdbc.jdbcdemo.dao.ProductDao;
import com.demo.jdbc.jdbcdemo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer theId) {
        return productDao.findById(theId);
    }

    @Override
    public void deleteById(Integer theId) {
        productDao.deleteById(theId);

    }

    @Override
    public void save(Product p) {
        productDao.save(p);
    }

    @Override
    public void update(Product p) {
        productDao.update(p);

    }
}

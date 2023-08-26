package com.demo.jdbc.jdbcdemo.rest;

import com.demo.jdbc.jdbcdemo.entity.Product;
import com.demo.jdbc.jdbcdemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> findAll() {
        return productService.findAll();

    }

    @GetMapping("/{theId}")
    public Product findById(@PathVariable Integer theId) {
        return productService.findById(theId);

    }

    @PostMapping("/")
    public void save(@RequestBody Product product) {
        productService.save(product);

    }

    @PutMapping("/")
    public void update(@RequestBody Product product) {
        productService.update(product);

    }

    @DeleteMapping("/{theId}")
    public void deleteById(@PathVariable Integer theId) {
        productService.deleteById(theId);
    }
}

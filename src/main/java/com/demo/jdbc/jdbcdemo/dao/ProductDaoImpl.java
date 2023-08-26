package com.demo.jdbc.jdbcdemo.dao;

import com.demo.jdbc.jdbcdemo.entity.Product;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private Connection con;

    @SneakyThrows
    public ProductDaoImpl() {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_directory",
                "bekka", "bekkajava");

    }

    @SneakyThrows
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String query = "select * from product";

        try (PreparedStatement st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {

                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setPlace(rs.getString(4));
                product.setWarranty(rs.getInt(5));
                products.add(product);

            }
        }


        return products;
    }

    @SneakyThrows
    @Override
    public Product findById(Integer theId) {

        String query = "select * from product where id=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, theId);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();

                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setPlace(rs.getString(4));
                product.setWarranty(rs.getInt(5));

                return product;
            }

        }

    }

    @SneakyThrows
    @Override
    public void deleteById(Integer theId) {
        String query = "delete from product where id =?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, theId);
            ps.executeUpdate();
        }
    }


    @SneakyThrows
    @Override
    public void save(Product p) {
        String query = "insert into product (name, type, place, warranty) values (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getType());
            ps.setString(3, p.getPlace());
            ps.setInt(4, p.getWarranty());
            ps.executeUpdate();
        }
    }

    @SneakyThrows
    @Override

    public void update(Product p) {
        String query = "update product set name =?, type =?, place =?, warranty =? where id =?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getType());
            ps.setString(3, p.getPlace());
            ps.setInt(4, p.getWarranty());
            ps.setInt(5, p.getId());

            ps.executeUpdate();
        }
    }
}

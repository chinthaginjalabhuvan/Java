package com.bikestores.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bikestores.model.Product;
import com.bikestores.util.DBConnection;

public class ProductService {
	public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.product_id, p.product_name, b.brand_name, c.category_name, p.model_year, p.list_price " +
                     "FROM production.products p " +
                     "JOIN production.brands b ON p.brand_id = b.brand_id " +
                     "JOIN production.categories c ON p.category_id = c.category_id";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setBrand(rs.getString(3));
                product.setCategory(rs.getString(4));
                product.setModelYear(rs.getInt(5));
                product.setPrice(rs.getDouble(6));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

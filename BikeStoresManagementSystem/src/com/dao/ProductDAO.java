package com.dao;
import com.model.Product;
import com.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("Database connection failed!");
            return products;
        }

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT brand_id, category_id, model_year, list_price FROM production.products")) {

            while (rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

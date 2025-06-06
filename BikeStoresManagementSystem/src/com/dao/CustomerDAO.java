package com.dao;
import com.model.Customer;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class CustomerDAO {
    // Method to add a customer
    public void addCustomer(Customer customer) {
        Connection con = DBConnection.getConnection();
 
        if (con == null) {
            System.out.println("Cannot add customer - Database connection failed!");
            return;
        }
 
        String query = "INSERT INTO sales.customers (first_name, last_name, email, city) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getCity());
 
            stmt.executeUpdate();
            System.out.println("Customer added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    // Method to search for a customer by name, email, or city
    public List<Customer> searchCustomer(String keyword) {
        List<Customer> customers = new ArrayList<>();
        Connection con = DBConnection.getConnection();
 
        if (con == null) {
            System.out.println("Database connection failed!");
            return customers;
        }
 
        String query = "SELECT * FROM sales.customers WHERE first_name LIKE ? OR email LIKE ? OR city LIKE ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
 
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("city")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
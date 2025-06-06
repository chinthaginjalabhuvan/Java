package com.bikestores.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bikestores.util.DBConnection;

public class ReportService {
	 public void generateReports() {
	        totalSalesPerStore();
	        topSellingProducts();
	        monthlySalesTrends();
	    }

	    private void totalSalesPerStore() {
	        String sql = "SELECT s.store_name, SUM(oi.quantity * oi.list_price) AS total_sales " +
	                     "FROM sales.order_items oi " +
	                     "JOIN sales.orders o ON oi.order_id = o.order_id " +
	                     "JOIN sales.stores s ON o.store_id = s.store_id " +
	                     "GROUP BY s.store_id";
	        try (Connection conn = DBConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                System.out.println("Store: " + rs.getString(1) + " | Sales: " + rs.getDouble(2));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private void topSellingProducts() {
	        String sql = "SELECT p.product_name, SUM(oi.quantity) AS total_qty " +
	                     "FROM sales.order_items oi " +
	                     "JOIN production.products p ON oi.product_id = p.product_id " +
	                     "GROUP BY p.product_id ORDER BY total_qty DESC LIMIT 5";
	        try (Connection conn = DBConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            System.out.println("Top 5 Selling Products:");
	            while (rs.next()) {
	                System.out.println(rs.getString(1) + " - " + rs.getInt(2) + " units");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private void monthlySalesTrends() {
	        String sql = "SELECT DATE_FORMAT(order_date, '%Y-%m') AS month, SUM(oi.quantity * oi.list_price) AS total " +
	                     "FROM sales.orders o JOIN sales.order_items oi ON o.order_id = oi.order_id " +
	                     "GROUP BY month ORDER BY month";
	        try (Connection conn = DBConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            System.out.println("Monthly Sales Trends:");
	            while (rs.next()) {
	                System.out.println(rs.getString(1) + ": $" + rs.getDouble(2));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}

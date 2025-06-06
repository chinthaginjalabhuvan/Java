package com.service;
import com.dao.OrderDAO;
import com.util.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SalesReportService {
    private OrderDAO orderDAO = new OrderDAO();

    public void generateSalesReport() {
        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("Database connection failed!");
            return;
        }

        System.out.println("\n=== Sales Report ===");

        // Total Sales per Store
        System.out.println("\nTotal Sales Per Store:");
        generateTotalSalesPerStore(con);

        // Top 5 Selling Products
        System.out.println("\nTop 5 Selling Products:");
        generateTopSellingProducts(con);

        // Monthly Sales Trends
        System.out.println("\nMonthly Sales Trends:");
        generateMonthlySalesTrends(con);
    }

    private void generateTotalSalesPerStore(Connection con) {
    	String query = "SELECT store_id, SUM(list_price) AS total_sales FROM sales.orders INNER JOIN order_items USING(order_id) GROUP BY store_id";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Store ID: " + rs.getInt("store_id") + ", Total Sales: $" + rs.getDouble("total_sales"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void generateTopSellingProducts(Connection con) {
        String query = "SELECT product_id, SUM(quantity) AS total_sold FROM sales.order_items GROUP BY product_id ORDER BY total_sold DESC LIMIT 5";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id") + ", Units Sold: " + rs.getInt("total_sold"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void generateMonthlySalesTrends(Connection con) {
    	String query = "SELECT DATE_FORMAT(order_date, '%Y-%m') AS month, SUM(list_price) AS monthly_sales FROM sales.orders INNER JOIN order_items USING(order_id) GROUP BY month ORDER BY month";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Month: " + rs.getString("month") + ", Total Sales: $" + rs.getDouble("monthly_sales"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.bikestores.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.bikestores.model.Order;
import com.bikestores.model.OrderItem;
import com.bikestores.util.DBConnection;

public class OrderService {
	public void placeOrder(Order order) {
        String orderSql = "INSERT INTO sales.orders (customer_id, store_id, order_date) VALUES (?, ?, ?)";
        String itemSql = "INSERT INTO sales.order_items (order_id, item_id, product_id, quantity, list_price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement orderStmt = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setInt(1, order.getCustomerId());
            orderStmt.setInt(2, order.getStoreId());
            orderStmt.setDate(3, Date.valueOf(LocalDate.now()));
            orderStmt.executeUpdate();

            
            ResultSet generatedKeys = orderStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int orderId = generatedKeys.getInt(1);
                PreparedStatement itemStmt = conn.prepareStatement(itemSql);
                int itemId = 1;
                for (OrderItem item : order.getItems()) {
                    itemStmt.setInt(1, orderId);
                    itemStmt.setInt(2, itemId++);
                    itemStmt.setInt(3, item.getProductId());
                    itemStmt.setInt(4, item.getQuantity());
                    itemStmt.setDouble(5, item.getPrice());
                    itemStmt.addBatch();
                }
                itemStmt.executeBatch();
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

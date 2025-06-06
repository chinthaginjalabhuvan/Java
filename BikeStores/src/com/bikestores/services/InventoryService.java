package com.bikestores.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bikestores.util.DBConnection;

public class InventoryService {
	public boolean isStockAvailable(int storeId, int productId, int requestedQty) {
        String sql = "SELECT quantity FROM production.stocks WHERE store_id = ? AND product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, storeId);
            pstmt.setInt(2, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity") >= requestedQty;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

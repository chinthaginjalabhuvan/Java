package com.dao;
import com.util.DBConnection;
import java.sql.*;
 
public class StockDAO {
    public boolean checkStock(int productId, int storeId, int quantity) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            System.out.println("Database connection failed!");
            return false;
        }
 
        String query = "SELECT quantity FROM production.stocks WHERE product_id = ? AND store_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, productId);
            stmt.setInt(2, storeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity") >= quantity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
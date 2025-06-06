package com.service;
import com.dao.OrderDAO;
import com.dao.ProductDAO;
import java.util.Scanner;
public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private ProductDAO productDAO = new ProductDAO();
    public void placeOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();
        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Total Amount: ");
        double totalAmount = sc.nextDouble();
        System.out.print("Enter Item ID: ");
        int itemId = sc.nextInt();
 

        if (checkStockAvailability(productId, quantity)) {
            orderDAO.addOrder(customerId, productId, quantity, totalAmount, itemId);  
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Insufficient stock! Cannot place order.");
        }
    }
    private boolean checkStockAvailability(int productId, int quantity) {
        return true; // Placeholder; implement actual stock verification logic
    }
}
package com.bikestores.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bikestores.model.Customer;
import com.bikestores.model.Order;
import com.bikestores.model.OrderItem;
import com.bikestores.services.CustomerService;
import com.bikestores.services.InventoryService;
import com.bikestores.services.OrderService;
import com.bikestores.services.ProductService;
import com.bikestores.services.ReportService;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        InventoryService inventoryService = new InventoryService();
        ReportService reportService = new ReportService();

        while (true) {
            System.out.println("\n====== BikeStores Inventory & Sales Management ======");
            System.out.println("1. View Product Catalog");
            System.out.println("2. Add New Customer");
            System.out.println("3. Search Customers");
            System.out.println("4. Place an Order");
            System.out.println("5. Check Inventory");
            System.out.println("6. Generate Sales Report");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    productService.getAllProducts().forEach(p -> System.out.printf(
                        "ID: %d | Name: %s | Brand: %s | Category: %s | Year: %d | Price: %.2f\n",
                        p.getId(), p.getName(), p.getBrand(), p.getCategory(), p.getModelYear(), p.getPrice()
                    ));
                    break;

                case "2":
                    try {
                        Customer customer = new Customer();
                        System.out.print("First Name: ");
                        customer.setFirstName(scanner.nextLine().trim());
                        System.out.print("Last Name: ");
                        customer.setLastName(scanner.nextLine().trim());
                        System.out.print("Email: ");
                        customer.setEmail(scanner.nextLine().trim());
                        System.out.print("City: ");
                        customer.setCity(scanner.nextLine().trim());
                        customerService.addCustomer(customer);
                        System.out.println("Customer added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Database Error: " + e.getMessage());
                    }
                    break;

                case "3":
                    System.out.print("Enter keyword to search (name/email/city): ");
                    String keyword = scanner.nextLine().trim();
                    List<Customer> results = customerService.searchCustomers(keyword);
                    results.forEach(c -> System.out.printf("ID: %d | %s %s | Email: %s | City: %s\n",
                            c.getId(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getCity()));
                    if (results.isEmpty()) {
                        System.out.println("No matching customers found.");
                    }
                    break;

                case "4":
                    try {
                        Order order = new Order();
                        System.out.print("Customer ID: ");
                        order.setCustomerId(Integer.parseInt(scanner.nextLine()));
                        System.out.print("Store ID: ");
                        order.setStoreId(Integer.parseInt(scanner.nextLine()));
                        
                        List<OrderItem> items = new ArrayList<>();
                        double totalAmount = 0;

                        while (true) {
                            System.out.print("Enter Product ID (or 0 to finish): ");
                            int pid = Integer.parseInt(scanner.nextLine());
                            if (pid == 0) break;

                            System.out.print("Quantity: ");
                            int qty = Integer.parseInt(scanner.nextLine());

                            if (!inventoryService.isStockAvailable(order.getStoreId(), pid, qty)) {
                                System.out.println("Insufficient stock! Try again.");
                                continue;
                            }

                            System.out.print("Price per unit: ");
                            double price = Double.parseDouble(scanner.nextLine());

                            double itemTotal = qty * price;
                            totalAmount += itemTotal;

                            OrderItem item = new OrderItem();
                            item.setProductId(pid);
                            item.setQuantity(qty);
                            item.setPrice(price);
                            items.add(item);
                        }

                        if (!items.isEmpty()) {
                            System.out.println("Total Amount: " + totalAmount);
                            System.out.print("Do you want to proceed with the order? (Yes/No): ");
                            String confirmation = scanner.nextLine().trim().toLowerCase();

                            if (confirmation.equals("yes")) {
                                order.setItems(items);
                                orderService.placeOrder(order);
                                System.out.println("Order placed successfully!");
                                System.out.println("Order Summary:");
                                System.out.println("Customer ID: " + order.getCustomerId());
                                System.out.println("Store ID: " + order.getStoreId());
                                System.out.println("Total Amount: " + totalAmount);
                            } else {
                                System.out.println("Order cancelled.");
                            }
                        } else {
                            System.out.println("No items added. Order cancelled.");
                        }

                    } catch (Exception e) {
                        System.out.println("Error placing order: " + e.getMessage());
                    }
                    break;

//                    try {
//                        Order order = new Order();
//                        System.out.print("Customer ID: ");
//                        order.setCustomerId(Integer.parseInt(scanner.nextLine()));
//                        System.out.print("Store ID: ");
//                        order.setStoreId(Integer.parseInt(scanner.nextLine()));
//                        List<OrderItem> items = new ArrayList<>();
//
//                        while (true) {
//                            System.out.print("Enter Product ID (or 0 to finish): ");
//                            int pid = Integer.parseInt(scanner.nextLine());
//                            if (pid == 0) break;
//
//                            System.out.print("Quantity: ");
//                            int qty = Integer.parseInt(scanner.nextLine());
//
//                            if (!inventoryService.isStockAvailable(order.getStoreId(), pid, qty)) {
//                                System.out.println("Insufficient stock! Try again.");
//                                continue;
//                            }
//
//                            System.out.print("Price per unit: ");
//                            double price = Double.parseDouble(scanner.nextLine());
//
//                            OrderItem item = new OrderItem();
//                            item.setProductId(pid);
//                            item.setQuantity(qty);
//                            item.setPrice(price);
//                            items.add(item);
//                        }
//
//                        if (!items.isEmpty()) {
//                            order.setItems(items);
//                            orderService.placeOrder(order);
//                            System.out.println("Order placed successfully!");
//                        } else {
//                            System.out.println("No items added. Order cancelled.");
//                        }
//
//                    } catch (Exception e) {
//                        System.out.println("Error placing order: " + e.getMessage());
//                    }
//                    break;

                case "5":
                    try {
                        System.out.print("Store ID: ");
                        int storeId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Product ID: ");
                        int productId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Requested Quantity: ");
                        int qty = Integer.parseInt(scanner.nextLine());

                        boolean available = inventoryService.isStockAvailable(storeId, productId, qty);
                        if (available) {
                            System.out.println("Stock is available.");
                        } else {
                            System.out.println("Stock is insufficient.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format.");
                    }
                    break;

                case "6":
                    reportService.generateReports();
                    break;

                case "7":
                    System.out.println("Exiting BikeStores System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}

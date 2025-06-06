package com.service;
import com.dao.CustomerDAO;
import com.model.Customer;
import com.util.Validator;
import com.util.InvalidEmailException;
import java.util.List;
import java.util.Scanner;
 
public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();
 
    public void addCustomer() {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine().trim();
        if (firstName.isEmpty()) {
            System.out.println("Error: First name cannot be empty!");
            return;
        }
 
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Enter City: ");
        String city = sc.nextLine().trim();
 
        try {
            if (!Validator.isValidEmail(email)) {
                throw new InvalidEmailException("Invalid email format! Please enter a valid email.");
            }
            Customer customer = new Customer(0, firstName, lastName, email, city);
            customerDAO.addCustomer(customer);
            System.out.println("Customer registered successfully!");
        } catch (InvalidEmailException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    public void searchCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter search keyword (name, email, or city): ");
        String keyword = sc.nextLine().trim();
 
        if (keyword.isEmpty()) {
            System.out.println("Error: Search keyword cannot be empty!");
            return;
        }
 
        List<Customer> customers = customerDAO.searchCustomer(keyword);
        if (customers.isEmpty()) {
            System.out.println("No customers found with that search!");
        } else {
            System.out.println("Search Results:");
            customers.forEach(System.out::println);
        }
    }
}
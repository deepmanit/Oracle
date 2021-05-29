package Dao;

import Entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> fetchCustomers();
}

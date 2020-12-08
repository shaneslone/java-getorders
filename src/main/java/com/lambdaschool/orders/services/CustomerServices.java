package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;

import java.sql.ClientInfoStatus;
import java.util.List;

public interface CustomerServices {
    Customer save(Customer customer);
    List<Customer> findAllOrders();
    Customer findById(long customerid);
    List<Customer> findByNameLike(String substring);
}

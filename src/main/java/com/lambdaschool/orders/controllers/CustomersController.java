package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomerServices customerServices;
    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllOrders() {
        List<Customer> myList = customerServices.findAllOrders();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
    // http://localhost:2019/customers/customer/{customerid}
    @GetMapping(value = "/customer/{customerid}", produces = "application/json")
    public ResponseEntity<?> findByCustomerId(@PathVariable long customerid) {
        Customer customer = customerServices.findById(customerid);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    // http://localhost:2019/customers/namelike/{substring}
    @GetMapping(value = "/namelike/{substring}", produces = "application/json")
    public ResponseEntity<?> findCustomersByNameLike(@PathVariable String substring){
        List<Customer> myList = customerServices.findByNameLike(substring);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}

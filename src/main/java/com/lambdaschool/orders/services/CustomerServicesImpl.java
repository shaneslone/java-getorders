package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerservices")
public class CustomerServicesImpl implements CustomerServices {
    @Autowired
    private CustomersRepository customersRepository;

    @Transactional
    @Override
    public Customer save(Customer customer){
        return customersRepository.save(customer);
    }

    @Override
    public List<Customer> findAllOrders() {
        List<Customer> rtnList = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Customer findById(long customerid) {
        Customer c = customersRepository.findById(customerid)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + customerid + " not found!"));
        return c;
    }

    @Override
    public List<Customer> findByNameLike(String substring) {
        List<Customer> list = customersRepository.findByCustnameContainingIgnoringCase(substring);
        return list;
    }
}

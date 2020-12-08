package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "orderservices")
public class OrderServicesImpl implements OrderServices {
    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    @Override
    public Order save(Order order){
        return ordersRepository.save(order);
    }

    @Override
    public Order findById(long orderid) {
        Order o = ordersRepository.findById(orderid)
                .orElseThrow(() -> new EntityNotFoundException("Order with id " + orderid + " not found!"));
        return o;
    }
}

package com.tudoan.orderservice.services;

import com.tudoan.orderservice.entities.Order;

public interface OrderService {
    Order save(Order order);
    Order findById(long id);
}

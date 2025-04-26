package com.tudoan.customerservice.services;

import com.tudoan.customerservice.entities.Customer;

public interface CustomerService {
    Customer save(Customer customer);
    Customer findById(long id);
}


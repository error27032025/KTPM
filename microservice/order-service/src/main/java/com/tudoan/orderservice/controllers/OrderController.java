package com.tudoan.orderservice.controllers;

import com.tudoan.orderservice.entities.Order;
import com.tudoan.orderservice.services.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {
    OrderService orderService;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping
    public Order get(@RequestParam long id) {
        return orderService.findById(id);
    }
}

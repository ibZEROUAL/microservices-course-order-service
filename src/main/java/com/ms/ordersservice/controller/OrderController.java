package com.ms.ordersservice.controller;

import com.ms.ordersservice.dto.OrderDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    public String placeOrder(@RequestBody OrderDto orderDto) {
        return "Order Placed Successfully";
    }

}

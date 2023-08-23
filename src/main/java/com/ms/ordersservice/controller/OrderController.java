package com.ms.ordersservice.controller;

import com.ms.ordersservice.dto.OrderDto;
import com.ms.ordersservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto) {

        orderService.placeOrder(orderDto);
        return "Order Placed Successfully";
    }

}

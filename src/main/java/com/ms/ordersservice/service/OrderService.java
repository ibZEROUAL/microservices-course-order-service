package com.ms.ordersservice.service;

import com.ms.ordersservice.dto.OrderDto;
import com.ms.ordersservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderDto placeOrder(OrderDto orderDto){
        return null;
    }

}

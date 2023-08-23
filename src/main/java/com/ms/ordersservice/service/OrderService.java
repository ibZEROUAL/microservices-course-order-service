package com.ms.ordersservice.service;

import com.ms.ordersservice.dto.OrderDto;
import com.ms.ordersservice.mapper.OrderMapper;
import com.ms.ordersservice.model.Order;
import com.ms.ordersservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public void placeOrder(OrderDto orderDto){

        Order order = orderMapper.orderDtoToOrder(orderDto);
        order.setOrderNumber(UUID.randomUUID().toString());

        orderRepository.save(order);
    }

    public List<OrderDto> getOrders(){
        return orderMapper.orderListToOrderDtoList(orderRepository.findAll());
    }

}

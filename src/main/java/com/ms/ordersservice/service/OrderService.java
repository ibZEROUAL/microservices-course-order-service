package com.ms.ordersservice.service;

import com.ms.ordersservice.dto.OrderDto;
import com.ms.ordersservice.mapper.OrderLineItemsMapper;
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

    private final OrderLineItemsService orderLineItemsService;

    private final OrderLineItemsMapper orderLineItemsMapper;

    public void placeOrder(OrderDto orderDto){

        Order order = orderMapper.orderDtoToOrder(orderDto);
        order.setOrderLineItems(orderLineItemsMapper.orderLineItemsDtoListToOrderLineItemsList(orderDto.getOrderLineItemsDtos()));

        order.getOrderLineItems().forEach(orderLineItems -> {
            orderLineItemsService.saveOrderLineItem(orderLineItems);
            orderLineItems.setOrder(order);
        });

        order.setOrderNumber("order".concat(UUID.randomUUID().toString()));

        orderRepository.save(order);
    }
    public List<OrderDto> getOrders(){

       return orderRepository.findAll().parallelStream()
                .map(order -> {
                   var orderLineItemsListDtos = orderLineItemsService.getOrderLineItemsByOrderNumber(order.getId());
                   var orderDto = orderMapper.orderToOrderDto(order);
                   orderDto.setOrderLineItemsDtos(orderLineItemsListDtos);
                   return orderDto;
                }).toList();
    }

}

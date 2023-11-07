package com.ms.ordersservice.service;

import com.ms.ordersservice.dto.OrderLineItemsDto;
import com.ms.ordersservice.mapper.OrderLineItemsMapper;
import com.ms.ordersservice.model.OrderLineItems;
import com.ms.ordersservice.repository.OrderLineItemsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderLineItemsService {

    private final OrderLineItemsRepository orderLineItemsRepository;

    private final OrderLineItemsMapper orderLineItemsMapper;


    public OrderLineItemsDto saveOrderLineItem(OrderLineItems orderLineItems){
       return orderLineItemsMapper.orderLineItemsToOrderLineItemsDto(orderLineItemsRepository.save(orderLineItems));
    }


    public List<OrderLineItemsDto> getOrderLineItemsByOrderNumber(Long orderNumber){

        var orderLineItemsList =  orderLineItemsRepository.findAll().parallelStream()
                .filter(orderLineItems -> orderLineItems.getOrder().getId().equals(orderNumber))
                .toList();

        return orderLineItemsMapper.orderLineItemsListToOrderLineItemsDtoList(orderLineItemsList);
    }

}

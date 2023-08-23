package com.ms.ordersservice.mapper;

import com.ms.ordersservice.dto.OrderLineItemsDto;
import com.ms.ordersservice.model.OrderLineItems;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderLineItemsMapper {

    OrderLineItemsDto orderLineItemsToOrderLineItemsDto(OrderLineItems orderLineItems);

    OrderLineItems orderLineItemsDtoToOrderLineItems(OrderLineItemsDto orderLineItemsDto);

    List<OrderLineItemsDto> orderLineItemsListToOrderLineItemsDtoList(List<OrderLineItems> orderLineItemsList);

    List<OrderLineItems> orderLineItemsDtoListToOrderLineItemsList(List<OrderLineItemsDto> orderLineItemsDtoList);
}

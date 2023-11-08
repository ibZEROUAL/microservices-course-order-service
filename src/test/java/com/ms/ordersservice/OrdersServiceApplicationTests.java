package com.ms.ordersservice;

import com.ms.ordersservice.repository.OrderLineItemsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdersServiceApplicationTests {

	@Autowired
	OrderLineItemsRepository orderLineItemsRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void myTest(){

		orderLineItemsRepository.updateOrderLineItemsByOrderId(1L,2L);
	}

}

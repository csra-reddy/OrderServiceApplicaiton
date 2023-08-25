package com.example.orderserviceapplication.OrderServiceApplicaiton;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class OrderServiceApplicaitonApplicationTests {

	@InjectMocks
	OrderController orderController;
	
	@Mock
	OrderService orderService;
	
	@Test
	public void testgetOrdersById(){
        
		Long orderId=(long) 1;
		Order sampleOrder=new Order();
	    sampleOrder.setId(1L);
	    sampleOrder.setBuyer("Chandra");
	    sampleOrder.setPrice(30000.0);
	    sampleOrder.setQty(10);
	    
		when(orderService.getOrderById(orderId)).thenReturn(sampleOrder);
		
		ResponseEntity<Order> responseEntity=orderController.getOrderById(orderId);
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(sampleOrder);
		
	}

}
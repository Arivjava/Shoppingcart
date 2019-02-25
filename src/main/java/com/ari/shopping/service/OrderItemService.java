package com.ari.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ari.shopping.model.OrderItem;
import com.ari.shopping.repository.OrderItemRepository;
import com.ari.shopping.to.OrderItemTO;

@Service
public class OrderItemService {
   
		@Autowired
		OrderItemRepository  orderItemRepository;
		
/***************************** Convert list of OrderItemTO to list of OrderItem *********************************************/
		public List<OrderItem> getOrderItem(List<OrderItemTO> orderItemTOs){
		
		List<OrderItem> orderItems = new ArrayList<>();
		orderItemTOs.forEach((OrderItemTO) -> { 
													OrderItem orderItem = new OrderItem(OrderItemTO.getProductCode(),
																						OrderItemTO.getQty(),
																						OrderItemTO.getPurchasePrice()
																						);	
													orderItems.add(orderItem);
											   } );
		return orderItems;
		}
	
		public OrderItemService() {
		// TODO Auto-generated constructor stub
		}

}

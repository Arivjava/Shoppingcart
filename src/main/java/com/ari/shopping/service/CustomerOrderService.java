package com.ari.shopping.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ari.shopping.model.CustomerOrder;
import com.ari.shopping.model.OrderItem;
import com.ari.shopping.repository.CustomerOrderRepository;
import com.ari.shopping.repository.CustomerRepository;
import com.ari.shopping.repository.OrderItemRepository;
import com.ari.shopping.to.CustomerOrderTO;
import com.ari.shopping.to.OrderItemTO;

@Service
public class CustomerOrderService {

	@Autowired
	CustomerOrderRepository  customerOrderRepository;
	@Autowired
	OrderItemRepository  orderItemRepository;
	@Autowired
	CustomerRepository  customerRepository;
	@Autowired
	CustomerService  customerService;
	@Autowired
	OrderItemService  orderItemService;

/***************************** Convert CustomerOrderTO to CustomerOrder *****************************************************/
	public CustomerOrder getCustomerOrder(CustomerOrderTO customerOrderTO){
	
		CustomerOrder customerOrder = new CustomerOrder(customerService.getCustomer(customerOrderTO.getCustomerTO()),
			  							 				LocalDate.now(),
			  							 				"ORDERED"
			  							 			//	orderItemService.getOrderItem(customerOrderTO.getOrderItemTOs())
			  							 				);
		return customerOrder;
	}

/***************************** Place the order , save customer, customer_orders , order_items *******************************/
	public boolean placeOrder(CustomerOrderTO customerOrderTO) {
	try{    
		
			CustomerOrder customerOrder = getCustomerOrder(customerOrderTO);
						
			List<OrderItem> orderItems ;
			
			orderItems = orderItemService.getOrderItem(customerOrderTO.getOrderItemTOs());
			
			orderItems.forEach( (OrderItem) -> {	OrderItem.setCustomerOrder(customerOrder);
													orderItemRepository.save(OrderItem);}
							  );
				
			return true;
		}

	catch(Exception ex) {
		ex.printStackTrace();
		return false;
		
		}
	}

	
	public CustomerOrderService() {
		// TODO Auto-generated constructor stub
	}

}

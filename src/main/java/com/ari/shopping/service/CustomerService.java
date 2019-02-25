package com.ari.shopping.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ari.shopping.model.Customer;
import com.ari.shopping.model.CustomerOrder;
import com.ari.shopping.model.OrderItem;
import com.ari.shopping.repository.CustomerRepository;
import com.ari.shopping.repository.OrderItemRepository;
import com.ari.shopping.to.CustomerOrderTO;
import com.ari.shopping.to.CustomerTO;
import com.ari.shopping.to.OrderItemTO;
 
@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
/***************************** Convert CustomerTO to Customer ****************************************************************/
	public Customer getCustomer(CustomerTO customerTO ){
	   		
		/*************Already existing customer by contact number & customer name *********************/
		
		Customer customer = customerRepository.findByContactNoAndCustomerName(customerTO.getContactNo(),
																			  customerTO.getCustomerName());	
		
		if(null != customer ) { 
			return customer; 
		}
		
		/*************************************New Customer  *******************************************/
		
		Customer newCustomer = new Customer(customerTO.getCustomerName(),
										 customerTO.getDeliveryAddress(),
										 customerTO.getContactNo());
		return newCustomer ;
	}
	
	public CustomerService() {
		// TODO Auto-generated constructor stub
	}

}

package com.ari.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ari.shopping.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	public Customer findByContactNo(String contactNo);
	
	public Customer findByContactNoAndCustomerName(String contactNo,String customerName);
	
}

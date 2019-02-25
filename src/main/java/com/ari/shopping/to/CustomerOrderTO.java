package com.ari.shopping.to;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomerOrderTO {

	private CustomerTO customerTO;
	private List<OrderItemTO> orderItemTOs;
	private int totalItem;
	private double total;

	public CustomerTO getCustomerTO() {
		return customerTO;
	}

	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}

	public List<OrderItemTO> getOrderItemTOs() {
		return orderItemTOs;
	}

	public void addOrderItemTos(OrderItemTO orderItem) {

		this.orderItemTOs.add(orderItem);
		refersh();
	}

	public CustomerOrderTO(CustomerTO customerTO, List<OrderItemTO> orderItemTOs) {
		super();
		this.customerTO = customerTO;
		this.orderItemTOs = orderItemTOs;
	}

	@Override
	public String toString() {
		return "CustomerOrderTO [customerTO=" + customerTO + ", orderItemTOs=" + orderItemTOs + "]";
	}

	public CustomerOrderTO() {

		orderItemTOs = new ArrayList<>();
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public double getTotal() {
		return total;
	}

	private void refersh() {

		setTotalItem(orderItemTOs.size());
		total = orderItemTOs.stream().mapToDouble(
				val -> val.getPurchasePrice()).sum();
	}
	
	public void deleteItem(String pCode) {

		orderItemTOs.removeIf(val -> val.getProductCode().equals(pCode));
		refersh();
	}
	
	public void reset() {

		customerTO = null;
		orderItemTOs.clear();
		refersh();
	}

}

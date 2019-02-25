package com.ari.shopping.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ari.shopping.model.Product;
import com.ari.shopping.service.CustomerOrderService;
import com.ari.shopping.service.CustomerService;
import com.ari.shopping.service.OrderItemService;
import com.ari.shopping.to.CustomerForm;
import com.ari.shopping.to.CustomerOrderTO;
import com.ari.shopping.to.CustomerTO;
import com.ari.shopping.to.ItemForm;
import com.ari.shopping.to.OrderItemTO;

@Controller
public class ProductController {

    @Autowired
    CustomerService customerService ;
    
    @Autowired
    CustomerOrderService  customerOrderService ;
    
    @Autowired
    OrderItemService  orderItemService ;
    

	@Autowired
	private CustomerOrderTO cart;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	// Product List page.
	@RequestMapping("/skymall")
	public String listProductHandler(Model model) {

		RestTemplate template = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<List<Product>> result = template.exchange("http://localhost:9090/products/", HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<Product>>() {
				});

		List<Product> products = result.getBody();
		System.out.println(products);
		model.addAttribute("products", products);
		model.addAttribute("itemForm", new ItemForm());
		model.addAttribute("cart", cart);

		return "listproducts";
	}

	@RequestMapping(path = "/addToCart", method = RequestMethod.POST)
	public String addToCart(@ModelAttribute("itemForm") ItemForm itemForm, Model model) {

		final int qty = Integer.parseInt(itemForm.getQty());
		final double itemPrice = Double.valueOf(itemForm.getUnitPrice());
		final double itemtotal = itemPrice * qty;

		final OrderItemTO orderItem = new OrderItemTO(itemForm.getCode(), itemForm.getName(), qty, itemPrice,
				itemtotal);
		cart.addOrderItemTos(orderItem);
		return "redirect:/skymall";  // postget pattern
	}

	@RequestMapping("/cart")
	public String cart(Model model) {

		model.addAttribute("cart", cart);
		return "cart";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("pCode") String pCode) {

		System.out.println(pCode);
		cart.deleteItem(pCode);
		return "redirect:/cart";
	}

	@RequestMapping("/addCustomer")
	public String addCustomer(Model model) {

		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("cart", cart);
		return "order";
	}

	@RequestMapping(path = "/addCustomer", method = RequestMethod.POST)
	public String addCustomerPost(@ModelAttribute("customerForm") CustomerForm customerForm, Model model) {
		
		System.out.println(customerForm);
		
		final CustomerTO customer = new CustomerTO(
				customerForm.getName(), 
				customerForm.getAddress(), 
				customerForm.getPhone());
		cart.setCustomerTO(customer);
		
		customerOrderService.placeOrder(cart);
		cart.reset();
		return "success";
	}

	public CustomerOrderTO getCart() {
		return cart;
	}

	public void setCart(CustomerOrderTO cart) {
		this.cart = cart;
	}

	
}

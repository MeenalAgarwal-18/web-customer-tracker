package com.customertracker.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.customertracker.springdemo.entity.Customer;
import com.customertracker.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel){
		List<Customer> customersList = customerService.getCustomersList();
		theModel.addAttribute("customersList", customersList);
		return "list-customers";
	}
	
	@GetMapping("/showAddCustomerForm")
	public String showAddCustomerForm(Model theModel){
		Customer theCustomer = new Customer();
		theModel.addAttribute("theCustomer", theCustomer);
		return "show-customer-form";
	}
	
	/* To save new/existing customer */ 
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("theCustomer") Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showCustomerForm")
	public String showCustomerForm(@RequestParam("customerId") int customerId,Model theModel){
		Customer theCustomer = customerService.showCustomerForm(customerId);
		theModel.addAttribute("theCustomer", theCustomer);
		return "show-customer-form";
	}
	
	@GetMapping("/showDeleteCustomerForm")
	public String showDeleteCustomerForm(@RequestParam("customerId") int customerId){
		
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/searchCustomer")
	
	public String searchCustomer(@RequestParam("theSearchInput") String searchName,Model theModel){
		
		List<Customer> customersList = customerService.searchCustomer(searchName);
		theModel.addAttribute("customersList", customersList);
		return "list-customers";
	}
}

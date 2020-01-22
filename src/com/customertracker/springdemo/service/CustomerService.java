package com.customertracker.springdemo.service;

import java.util.List;

import com.customertracker.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomersList();
	
	public void saveCustomer(Customer theCustomer);

	public Customer showCustomerForm(int customerId);

	public void deleteCustomer(int customerId);

	public List<Customer> searchCustomer(String searchName);
	
}

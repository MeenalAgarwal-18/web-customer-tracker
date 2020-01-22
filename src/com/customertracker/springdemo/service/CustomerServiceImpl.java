package com.customertracker.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customertracker.springdemo.dao.CustomerDAO;
import com.customertracker.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject the CustomerDAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomersList() {
		return customerDAO.getCustomersList();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
          customerDAO.saveCustomer(theCustomer);
		
	}

	@Transactional
	@Override
	public Customer showCustomerForm(int customerId) {
		return customerDAO.showCustomerForm(customerId);
		
	}

	@Transactional
	@Override
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
		
	}

	@Transactional
	@Override
	public List<Customer> searchCustomer(String searchName) {
		return customerDAO.searchCustomer(searchName);
	}

}

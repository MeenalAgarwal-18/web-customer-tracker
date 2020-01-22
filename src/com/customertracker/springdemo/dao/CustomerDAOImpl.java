package com.customertracker.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.stereotype.Repository;

import com.customertracker.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomersList() {
		//Get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//Create query
		Query<Customer> createQuery = session.createQuery("from Customer order by firstName", Customer.class);
		//Execute the query and get the result list
		
		//Return the results
		List<Customer> resultList = createQuery.getResultList();
		
				
		return resultList;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		//Get the current session
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer showCustomerForm(int customerId) {
		//Get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//Fetch the customer details using customerId
		Customer theCustomer = session.get(Customer.class, customerId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int customerId) {
	   //Get the current session
	   Session session = sessionFactory.getCurrentSession();
	   //Get the customer using the primary key
	   Customer customer = session.get(Customer.class,customerId);
	   session.delete(customer);
	}


	@Override
	public List<Customer> searchCustomer(String searchName) {
		//Get the current session
		Session session = sessionFactory.getCurrentSession();
		Query createQuery = null;
		//Search Name is not empty
		if(searchName != null && searchName.trim().length() > 0){
			
			createQuery = session.createQuery("from Customer where lower(firstName) LIKE :theName "
					                          + "OR lower(lastName) LIKE :theName order by firstName", Customer.class);
			createQuery.setParameter("theName","%"+searchName.toLowerCase()+"%");
		}
		else{
			
			createQuery = session.createQuery("from Customer order by firstName", Customer.class);
		}
		return createQuery.getResultList();
	}

}

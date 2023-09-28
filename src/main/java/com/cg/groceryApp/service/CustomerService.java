package com.cg.groceryApp.service;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.cg.groceryApp.entities.Customer;
import com.cg.groceryApp.exception.ResourceNotFound;
import com.cg.groceryApp.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(@Validated Customer customer) 
	{
		
		return this.customerRepository.save(customer);
	}

	public Customer loginCustomer(Customer customer) 
	{
		
		return this.customerRepository.findByCustomerEmailIdAndCustomerPassword(customer.customerEmailId,customer.customerPassword).orElseThrow(()->new ResourceNotFound("Customer ","Id",customer.customerEmailId+"and password"+customer.customerPassword));
	}

	public List<Customer> getAllCustomers() 
	{
		
		return customerRepository.findAll();
	}

	public Customer updateCustomer(Customer customer, long customerId) 
	{
		Customer existingCustomer=customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFound("Customer","id",customerId));
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setDistrict(customer.getDistrict());
		existingCustomer.setPhoneNumber(customer.getPhoneNumber());
		existingCustomer.setState(customer.getState());
		existingCustomer.setPinCode(customer.getPinCode());
		existingCustomer.setCustomerEmailId(customer.getCustomerEmailId());
		existingCustomer.setCustomerPassword(customer.getCustomerPassword());
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	public Customer findByCustomerEmailId(Customer customer) 
	{
		
		return this.customerRepository.findByCustomerEmailId(customer.customerEmailId).orElseThrow(()->new ResourceNotFound("Customer ","Id",customer.customerEmailId+"and password"+customer.customerPassword));
	}

	public void deleteCustomer(long customerId) 
	{
		customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFound("Customer","id",customerId));
		customerRepository.deleteById(customerId);
	}

	public Customer getCustomerById(long customerId) {
		return customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFound("Customer ","Id",customerId));
	}

	
}
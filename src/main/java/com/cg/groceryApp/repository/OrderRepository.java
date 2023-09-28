package com.cg.groceryApp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.groceryApp.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{

	List<Order> findByCustomerCustomerId(long customerId);
	

}
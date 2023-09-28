package com.cg.groceryApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.groceryApp.entities.Cart;
import com.cg.groceryApp.entities.Customer;

public interface CartRepository extends JpaRepository<Cart,Long>
{

	void deleteCartByCustomer(Customer c);
	

}
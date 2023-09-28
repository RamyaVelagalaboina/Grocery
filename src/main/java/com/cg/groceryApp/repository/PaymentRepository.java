package com.cg.groceryApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.groceryApp.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
	

}
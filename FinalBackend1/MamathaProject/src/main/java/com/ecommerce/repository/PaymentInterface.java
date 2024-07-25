package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Payment;
import com.ecommerce.entity.User;

public interface PaymentInterface extends JpaRepository<Payment, Long> {
	
//	User findbyUserId(Long UserId);

}

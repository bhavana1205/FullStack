package com.ecommerce.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.User;

public interface UserRep  extends JpaRepository<User, Long>{
	
 
}

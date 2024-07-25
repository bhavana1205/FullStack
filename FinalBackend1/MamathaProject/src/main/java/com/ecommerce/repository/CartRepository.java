package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.CartIteam;
import com.ecommerce.entity.Chockolate;
import com.ecommerce.entity.Gift;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;

public interface CartRepository extends JpaRepository<CartIteam, Long>{
	  List<CartIteam> findByUserId(Long userId );
	  
	  CartIteam findFirstByUserId(Long userId );
	  
	  Optional<CartIteam> findByUserAndProduct(User user, Product product);
//	  Optional<CartIteam> findByUserAndChockolate(User user,Chockolate chockolate);
//	  Optional<CartIteam> findByUserAndGift(User user,Gift gift);
}

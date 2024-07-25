package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.CakeOption;

import com.ecommerce.entity.Product;

public interface CakeRep extends JpaRepository<CakeOption, Long>{
	
	List<Product> findByproduct_id(Long productid);

}

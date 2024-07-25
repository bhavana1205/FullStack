package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.AllChartDetails;
import com.ecommerce.entity.CartIteam;
import com.ecommerce.entity.Chockolate;
import com.ecommerce.entity.Dryfruites;
import com.ecommerce.entity.Gift;
import com.ecommerce.entity.Others;
import com.ecommerce.entity.Plants;
import com.ecommerce.entity.User;

public interface AllCartRep extends JpaRepository<AllChartDetails, Long>{
	 List<AllChartDetails> findByUserId(Long userId );
	  
	 AllChartDetails findFirstByUserId(Long userId );
	  
	  Optional<AllChartDetails> findByUserAndChockolate(User user, Chockolate product);
	  Optional<AllChartDetails> findByUserAndChockolate(User user,Others chockolate);
	  Optional<AllChartDetails> findByUserAndGift(User user,Gift gift);
	  Optional<AllChartDetails> findByUserAndPlants(User user,Plants gift);
	  Optional<AllChartDetails> findByUserAndDryfruites(User user,Dryfruites gift);
}

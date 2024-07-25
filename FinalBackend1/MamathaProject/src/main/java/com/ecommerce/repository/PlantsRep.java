package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Dryfruites;
import com.ecommerce.entity.Plants;

public interface PlantsRep extends JpaRepository<Plants, Long> {

}

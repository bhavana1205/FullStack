package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Dryfruites;
import com.ecommerce.entity.Flowers;

public interface FlowersRep extends JpaRepository<Flowers, Long> {

}

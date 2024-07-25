package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.DiwaliGifts;
import com.ecommerce.entity.Dryfruites;

public interface DiwaliRep extends JpaRepository<DiwaliGifts, Long> {

}

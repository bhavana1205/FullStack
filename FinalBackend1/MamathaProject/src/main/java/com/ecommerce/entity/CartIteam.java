package com.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartIteam {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    @JoinColumn(name = "product_id", nullable = false)
	    private Product product;
	    @ManyToOne
	    @JoinColumn(name = "user_Id", nullable = false)
	    private User user;
//	    @ManyToOne
//	    @JoinColumn(name = "Choco_Id", nullable = false)
//	    private Chockolate chockolate;
//	    @ManyToOne
//	    @JoinColumn(name = "gift_Id", nullable = false)
//	    private Gift gift;
	    private int quantity;

	
}

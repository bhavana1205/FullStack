package com.ecommerce.entity;




import java.util.List;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 private String productName;
	    private String productDescription;
	    private double productPrice;
	    private int quantityAvailable;
	    @Lob	
	    @Column(name = "imagedata", length = 1000)
	    private byte[] imageData;
	 
	   
	   
	    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<CakeOption>options;
}


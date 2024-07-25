package com.ecommerce.dto;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageData {

	 private String productName;
	    private String productDescription;
	    private double productPrice;
	    private int quantityAvailable;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;
}
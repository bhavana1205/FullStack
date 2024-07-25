package com.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllChartDetails {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    @JoinColumn(name = "user_Id", nullable = false)
	    private User user;
	    @ManyToOne
    @JoinColumn(name = "Choco_Id", insertable = false, updatable = false)
    private Chockolate chockolate;
	    @ManyToOne
    @JoinColumn(name = "gift_Id", insertable = false, updatable = false)
    private Gift gift;
	    private int quantity;
	    @ManyToOne
	    @JoinColumn(name = "others_Id", insertable = false, updatable = false)
	    private Others others;
	    @ManyToOne
	    @JoinColumn(name = "dry_Id", insertable = false, updatable = false)
	    private Dryfruites dryfruites;
	    @ManyToOne
	    @JoinColumn(name = "plant_Id", insertable = false, updatable = false)
	    private Plants plants;

}

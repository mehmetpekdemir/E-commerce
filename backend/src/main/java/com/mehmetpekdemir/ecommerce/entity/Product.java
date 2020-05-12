package com.mehmetpekdemir.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 12, 2020
 */
@Data
@NoArgsConstructor
@Entity(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "barcode", nullable = false, unique = true, length = 6)
	private String barcode;

	@Column(name = "price", nullable = false)
	private Double price;

	@Column(name = "description", nullable = false, length = 250)
	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	public Product(String name, String barcode, Double price, String description, Category category) {
		this.name = name;
		this.barcode = barcode;
		this.price = price;
		this.description = description;
		this.category = category;
	}
	
}

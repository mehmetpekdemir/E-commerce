package com.mehmetpekdemir.ecommerce.dto;

import java.io.Serializable;

import com.mehmetpekdemir.ecommerce.entity.Product;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */

@Getter
public class ProductViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Long id;
	private final String name;
	private final String barcode;
	private final Double price;
	private final String description;
	private final Long categoryId;

	private ProductViewDTO(Long id,String name, String barcode, Double price, String description, Long categoryId) {
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
	}

	public static ProductViewDTO of(Product product) {
		return new ProductViewDTO(
				product.getId(),
				product.getName(), 
				product.getBarcode(), 
				product.getPrice(), 
				product.getDescription(),
				product.getCategory().getId()
		);
	}

}

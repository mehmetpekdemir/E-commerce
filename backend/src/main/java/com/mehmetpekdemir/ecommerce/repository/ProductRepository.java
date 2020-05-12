package com.mehmetpekdemir.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmetpekdemir.ecommerce.entity.Product;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 12, 2020
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
	public Boolean existsByBarcode(String barcode);
}

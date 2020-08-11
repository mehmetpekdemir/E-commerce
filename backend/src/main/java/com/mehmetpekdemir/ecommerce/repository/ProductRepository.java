package com.mehmetpekdemir.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.ecommerce.entity.Product;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Boolean existsByBarcode(String barcode);

}

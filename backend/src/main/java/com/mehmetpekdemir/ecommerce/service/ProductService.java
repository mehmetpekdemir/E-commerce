package com.mehmetpekdemir.ecommerce.service;

import java.util.List;

import com.mehmetpekdemir.ecommerce.dto.ProductCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 12, 2020
 */
public interface ProductService {
	public List<ProductViewDTO> getProducts();

	public ProductViewDTO getProductById(Long productId);

	public ProductViewDTO createProduct(ProductCreateDTO productCreateDTO);
	
	public void deleteProduct(Long id);
}

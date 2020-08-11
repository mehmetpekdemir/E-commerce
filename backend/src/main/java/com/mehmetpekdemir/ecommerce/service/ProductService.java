package com.mehmetpekdemir.ecommerce.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.ecommerce.dto.ProductCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface ProductService {

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Cacheable(cacheNames = "getProducts")
	List<ProductViewDTO> getProducts();

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	ProductViewDTO getProductById(Long id);

	@CacheEvict(cacheNames = "getProducts")
	ProductViewDTO createProduct(ProductCreateDTO productCreateDTO);

	@CacheEvict(cacheNames = "getProducts")
	ProductViewDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO);

	@CacheEvict(cacheNames = "getProducts")
	void deleteProduct(Long id);

}

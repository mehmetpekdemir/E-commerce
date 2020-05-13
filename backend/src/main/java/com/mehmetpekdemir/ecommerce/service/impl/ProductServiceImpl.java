package com.mehmetpekdemir.ecommerce.service.impl;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.mehmetpekdemir.ecommerce.dto.ProductCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductViewDTO;
import com.mehmetpekdemir.ecommerce.entity.Category;
import com.mehmetpekdemir.ecommerce.entity.Product;
import com.mehmetpekdemir.ecommerce.exception.ServiceException;
import com.mehmetpekdemir.ecommerce.repository.ProductRepository;
import com.mehmetpekdemir.ecommerce.service.CategoryService;
import com.mehmetpekdemir.ecommerce.service.ProductService;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 12, 2020
 */
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
		this.productRepository = productRepository;
		this.categoryService = categoryService;
	}

	@Cacheable(cacheNames = "getProducts")
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<ProductViewDTO> getProducts() {
		return productRepository.findAll().stream().map(ProductViewDTO::of).collect(Collectors.toList());
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public ProductViewDTO getProductById(Long id) {
		Product product = getProductByIdCommon(id);
		return ProductViewDTO.of(product);
	}

	@CacheEvict(cacheNames = "getProducts")
	@Override
	public ProductViewDTO createProduct(ProductCreateDTO productCreateDTO) {
		AreTheseFieldsValid(productCreateDTO);

		Category category = categoryService.getCategoryByCategoryId(productCreateDTO.getCategoryId());

		Product product = productRepository.save(new Product(productCreateDTO.getName(), productCreateDTO.getBarcode(),
				productCreateDTO.getPrice(), productCreateDTO.getDescription(), category));
		return ProductViewDTO.of(product);
	}

	@CacheEvict(cacheNames = "getProducts")
	@Override
	public ProductViewDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO) {
		Product product = getProductByIdCommon(id);
		Category category = categoryService.getCategoryByCategoryId(productUpdateDTO.getCategoryId());

		AreTheseFieldsValid(productUpdateDTO);

		product.setName(productUpdateDTO.getName());
		product.setPrice(productUpdateDTO.getPrice());
		product.setDescription(productUpdateDTO.getDescription());
		product.setCategory(category);

		Product updatedProduct = productRepository.save(product);
		return ProductViewDTO.of(updatedProduct);
	}

	@CacheEvict(cacheNames = "getProducts")
	@Override
	public void deleteProduct(Long id) {
		Product product = getProductByIdCommon(id);
		productRepository.deleteById(product.getId());
	}

	private Product getProductByIdCommon(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ServiceException(String.format("Product not found with ID %d", id)));
	}

	private boolean notExistsByBarcode(String barcode) {
		return !productRepository.existsByBarcode(barcode);
	}

	private void AreTheseFieldsValid(ProductCreateDTO productCreateDTO) {
		Preconditions.checkArgument(isNotEmpty(productCreateDTO.getName()), "Product name cannot be empty !");
		Preconditions.checkArgument(isNotEmpty(productCreateDTO.getBarcode()), "Barcode cannot be empty !");
		Preconditions.checkArgument(isNotEmpty(productCreateDTO.getDescription()), "Description cannot be empty !");
		Preconditions.checkArgument(productCreateDTO.getPrice() > 0, "Price must be greater than 0");
		Preconditions.checkArgument(notExistsByBarcode(productCreateDTO.getBarcode()), "Barcode is already in use !");
	}

	private void AreTheseFieldsValid(ProductUpdateDTO productUpdateDTO) {
		Preconditions.checkArgument(isNotEmpty(productUpdateDTO.getName()), "Product name cannot be empty !");
		Preconditions.checkArgument(isNotEmpty(productUpdateDTO.getDescription()), "Description cannot be empty !");
		Preconditions.checkArgument(productUpdateDTO.getPrice() > 0, "Price must be greater than 0");
	}

}

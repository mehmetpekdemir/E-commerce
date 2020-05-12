package com.mehmetpekdemir.ecommerce.service.impl;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.mehmetpekdemir.ecommerce.dto.ProductCreateDTO;
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

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<ProductViewDTO> getProducts() {
		return productRepository.findAll().stream().map(ProductViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public ProductViewDTO getProductById(Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ServiceException(String.format("Product not found with ID %d", productId)));
		return ProductViewDTO.of(product);
	}

	@Override
	public ProductViewDTO createProduct(ProductCreateDTO productCreateDTO) {
		AreTheseFieldsEmpty(productCreateDTO);

		Preconditions.checkArgument(productCreateDTO.getPrice() > 0, "Price must be greater than 0");
		Preconditions.checkArgument(notExistsByBarcode(productCreateDTO.getBarcode()), "Barcode is already in use !");

		Category category = categoryService.getCategoryByCategoryId(productCreateDTO.getCategoryId());
		Product product = productRepository.save(new Product(productCreateDTO.getName(), productCreateDTO.getBarcode(),
				productCreateDTO.getPrice(), productCreateDTO.getDescription(), category));
		return ProductViewDTO.of(product);
	}

	@Override
	public void deleteProduct(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ServiceException(String.format("Product not found with ID %d", id)));
		productRepository.deleteById(product.getId());

	}

	private boolean notExistsByBarcode(String barcode) {
		return !productRepository.existsByBarcode(barcode);
	}

	private void AreTheseFieldsEmpty(ProductCreateDTO productCreateDTO) {
		Preconditions.checkArgument(isNotEmpty(productCreateDTO.getName()), "Product name cannot be empty !");
		Preconditions.checkArgument(isNotEmpty(productCreateDTO.getBarcode()), "Barcode cannot be empty !");
		Preconditions.checkArgument(isNotEmpty(productCreateDTO.getPrice().toString()), "Price cannot be empty !");
		Preconditions.checkArgument(isNotEmpty(productCreateDTO.getDescription()), "Description cannot be empty !");
	}

}

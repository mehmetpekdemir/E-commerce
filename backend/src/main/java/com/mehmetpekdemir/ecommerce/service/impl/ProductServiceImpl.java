package com.mehmetpekdemir.ecommerce.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mehmetpekdemir.ecommerce.dto.ProductCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductViewDTO;
import com.mehmetpekdemir.ecommerce.entity.Category;
import com.mehmetpekdemir.ecommerce.entity.Product;
import com.mehmetpekdemir.ecommerce.error.ServiceException;
import com.mehmetpekdemir.ecommerce.repository.ProductRepository;
import com.mehmetpekdemir.ecommerce.service.CategoryService;
import com.mehmetpekdemir.ecommerce.service.ProductService;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
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
	public List<ProductViewDTO> getProducts() {
		return productRepository.findAll().stream().map(ProductViewDTO::of).collect(Collectors.toList());
	}

	@Override
	public ProductViewDTO getProductById(Long id) {
		final Product product = getProductByIdCommon(id);
		return ProductViewDTO.of(product);
	}

	@Override
	public ProductViewDTO createProduct(ProductCreateDTO productCreateDTO) {
		final Category category = categoryService.getCategoryByCategoryId(productCreateDTO.getCategoryId());

		final Product product = productRepository
				.save(new Product(productCreateDTO.getName(), productCreateDTO.getBarcode(),
						productCreateDTO.getPrice(), productCreateDTO.getDescription(), category));
		return ProductViewDTO.of(product);
	}

	@Override
	public ProductViewDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO) {
		Product product = getProductByIdCommon(id);
		final Category category = categoryService.getCategoryByCategoryId(productUpdateDTO.getCategoryId());

		product.setName(productUpdateDTO.getName());
		product.setPrice(productUpdateDTO.getPrice());
		product.setDescription(productUpdateDTO.getDescription());
		product.setCategory(category);

		final Product updatedProduct = productRepository.save(product);
		return ProductViewDTO.of(updatedProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		final Product product = getProductByIdCommon(id);
		productRepository.deleteById(product.getId());
	}

	private Product getProductByIdCommon(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ServiceException(String.format("Product not found with ID %d", id)));
	}

}

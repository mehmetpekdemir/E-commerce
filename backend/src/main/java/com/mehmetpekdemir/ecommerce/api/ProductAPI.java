package com.mehmetpekdemir.ecommerce.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.ecommerce.dto.ProductCreateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductUpdateDTO;
import com.mehmetpekdemir.ecommerce.dto.ProductViewDTO;
import com.mehmetpekdemir.ecommerce.service.ProductService;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("api/")
public class ProductAPI {

	private final ProductService productService;

	public ProductAPI(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("v1/product")
	public ResponseEntity<List<ProductViewDTO>> getProducts() {
		final List<ProductViewDTO> products = productService.getProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("v1/product/{id}")
	public ResponseEntity<ProductViewDTO> getProductById(@PathVariable("id") Long id) {
		final ProductViewDTO product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	@PostMapping("v1/product")
	public ResponseEntity<ProductViewDTO> createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
		final ProductViewDTO product = productService.createProduct(productCreateDTO);
		return ResponseEntity.ok(product);
	}

	@PutMapping("v1/product/{id}")
	public ResponseEntity<ProductViewDTO> updateProduct(@PathVariable("id") Long id,
			@Valid @RequestBody ProductUpdateDTO productUpdateDTO) {
		final ProductViewDTO product = productService.updateProduct(id, productUpdateDTO);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("v1/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}

}

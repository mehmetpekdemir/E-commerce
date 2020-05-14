package com.mehmetpekdemir.ecommerce.api;

import java.util.List;

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
 * @since May 12, 2020
 */
@RestController
@RequestMapping("api/product")
public class ProductAPI {

	private final ProductService productService;

	public ProductAPI(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/get")
	public ResponseEntity<List<ProductViewDTO>> getProducts() {
		List<ProductViewDTO> products = productService.getProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ProductViewDTO> getProductById(@PathVariable("id") Long id) {
		ProductViewDTO product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	@PostMapping("/create")
	public ResponseEntity<ProductViewDTO> createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
		ProductViewDTO product = productService.createProduct(productCreateDTO);
		return ResponseEntity.ok(product);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ProductViewDTO> updateProduct(@PathVariable("id") Long id,
			@RequestBody ProductUpdateDTO productUpdateDTO) {
		ProductViewDTO product = productService.updateProduct(id, productUpdateDTO);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}

}

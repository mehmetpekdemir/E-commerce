package com.mehmetpekdemir.ecommerce.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.ecommerce.dto.ProductCreateDTO;
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
	public List<ProductViewDTO> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/get/{id}")
	public ProductViewDTO getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}

	@PostMapping("/create")
	public ProductViewDTO createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
		return productService.createProduct(productCreateDTO);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}

}

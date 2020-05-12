package com.mehmetpekdemir.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since May 11, 2020
 */
@Data
@NoArgsConstructor
@Entity(name = "categories")
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", nullable = false, unique = true, length = 50)
	private String name;

	@OneToMany(mappedBy = "category")
	private Set<Product> products = new HashSet<Product>();

	public Category(String name) {
		this.name = name;
	}
	
}

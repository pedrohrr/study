/* @(#)UserController 1.0 19/06/2017
 * Copyright (c) 2017, Embraer. All rights reserved. Embraer S/A
 * proprietary/confidential. Use is subject to license terms.
 */
package org.pedrohrr.ecomm.ecommerce.controller;

import org.pedrohrr.ecomm.ecommerce.dto.ProductDto;
import org.pedrohrr.ecomm.ecommerce.entity.Product;
import org.pedrohrr.ecomm.ecommerce.repository.ProductRepository;
import org.pedrohrr.ecomm.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for PRODUCT operations
 */
@RestController
@RequestMapping(path = "products")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductService service;

	/**
	 * List all products
	 * @return list of products
	 */
	@GetMapping
	public List<ProductDto> list() {
		return service.list();
	}

	/**
	 * Find one product by its id
	 * @param id - product id
	 * @return Product found
	 */
	@GetMapping(path = "/{id}")
	public ProductDto get(@PathVariable final int id) {
		return service.one(id);
	}

	/**
	 * Save a new product
	 * @param product - product content
	 * @return Product saved
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto save(@RequestBody final ProductDto product) {
		return service.save(product);
	}

	/**
	 * Deletes a product by its id
	 * @param id - product id
	 */
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final int id) {
		service.delete(id);
	}

}
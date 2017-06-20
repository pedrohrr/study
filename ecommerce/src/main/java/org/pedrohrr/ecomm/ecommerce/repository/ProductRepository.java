/* @(#)UserRepository 1.0 19/06/2017
 * Copyright (c) 2017, Embraer. All rights reserved. Embraer S/A
 * proprietary/confidential. Use is subject to license terms.
 */
package org.pedrohrr.ecomm.ecommerce.repository;

import org.pedrohrr.ecomm.ecommerce.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository for PRODUCT Entity
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findAll();
}
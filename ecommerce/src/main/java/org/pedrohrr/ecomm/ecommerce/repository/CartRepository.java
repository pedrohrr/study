package org.pedrohrr.ecomm.ecommerce.repository;

import org.pedrohrr.ecomm.ecommerce.entity.Cart;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for CART entity
 */
public interface CartRepository extends CrudRepository<Cart, Integer> {
}
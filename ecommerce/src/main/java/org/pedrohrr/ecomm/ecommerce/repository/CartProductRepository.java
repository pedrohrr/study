package org.pedrohrr.ecomm.ecommerce.repository;


import org.pedrohrr.ecomm.ecommerce.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;

public interface CartProductRepository extends CrudRepository<CartProduct, Integer> {
}

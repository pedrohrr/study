package org.pedrohrr.ecomm.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity class for CART table
 */
@Data
@Entity(name = "CART_PRODUCT")

public class CartProduct {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Product product;
    private Integer quantity;

    public CartProduct() {
    }

    public CartProduct(final Product product, final Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
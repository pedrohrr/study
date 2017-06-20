package org.pedrohrr.ecomm.ecommerce.dto;

import lombok.Data;
import org.pedrohrr.ecomm.ecommerce.entity.Cart;
import org.pedrohrr.ecomm.ecommerce.entity.Product;

import javax.persistence.ManyToOne;

@Data
public class CartProductDto {

    private Product product;
    private Integer quantity;

}
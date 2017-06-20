package org.pedrohrr.ecomm.ecommerce.entity;

import lombok.Data;
import org.pedrohrr.ecomm.ecommerce.dto.CartDto;
import org.pedrohrr.ecomm.ecommerce.exception.ProductNotInCartException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Repository for CART
 */
@Data
@Entity(name = "CART")
public class Cart {

    @Id
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartProduct> products;
    private String openedAt;

    @PrePersist
    public void open() {
        openedAt = LocalDateTime.now().toString();
    }

    public void addProduct(final Product product, final Integer quantity) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(new CartProduct(product, quantity));
    }

    public void changeQuantity(final Product product, final Integer quantity) {
        if (!containsProduct(product)) {
            throw new ProductNotInCartException();
        }
        getCartProductByProduct(product).setQuantity(quantity);
    }

    public void removeProduct(final Product product) {
        if (!containsProduct(product)) {
            throw new ProductNotInCartException();
        }
        products.remove(getCartProductByProduct(product));
    }

    private boolean containsProduct(final Product product) {
        return products != null && products.stream().filter(p -> p.getProduct().equals(product)).findAny().isPresent();
    }

    private CartProduct getCartProductByProduct(Product product) {
        return products.stream().filter(p -> p.getProduct().equals(product)).findAny().get();
    }

    public void empty() {
        if (products != null) {
            products.clear();
        }
    }
}
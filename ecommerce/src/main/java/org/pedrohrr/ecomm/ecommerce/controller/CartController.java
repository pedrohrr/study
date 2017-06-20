package org.pedrohrr.ecomm.ecommerce.controller;

import org.pedrohrr.ecomm.ecommerce.dto.AddProductDto;
import org.pedrohrr.ecomm.ecommerce.dto.CartDto;
import org.pedrohrr.ecomm.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "cart/products")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping
    public CartDto add(final AddProductDto dto) {
        return service.add(dto);
    }

    @PutMapping
    public CartDto changeQuantity(final AddProductDto dto) {
        return service.changeQuantity(dto);
    }

    @DeleteMapping(path = "/{id}")
    public CartDto remove(final int id) {
        return service.remove(id);
    }

    @DeleteMapping
    public CartDto empty() {
        return service.empty();
    }

}
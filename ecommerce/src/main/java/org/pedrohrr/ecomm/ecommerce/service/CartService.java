package org.pedrohrr.ecomm.ecommerce.service;

import org.pedrohrr.ecomm.ecommerce.dto.AddProductDto;
import org.pedrohrr.ecomm.ecommerce.dto.CartDto;
import org.pedrohrr.ecomm.ecommerce.entity.Cart;
import org.pedrohrr.ecomm.ecommerce.entity.Product;
import org.pedrohrr.ecomm.ecommerce.exception.CartNotFoundException;
import org.pedrohrr.ecomm.ecommerce.exception.ProductNotFoundException;
import org.pedrohrr.ecomm.ecommerce.mapper.CartMapper;
import org.pedrohrr.ecomm.ecommerce.repository.CartRepository;
import org.pedrohrr.ecomm.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartMapper cartMapper;

    @Transactional
    public CartDto add(final AddProductDto dto) {
        final Cart cart = getMockedCart();
        final Product product = getProduct(dto.getProduct());
        cart.addProduct(product, dto.getQuantity());
        return saveAndMap(cart);
    }

    @Transactional
    public CartDto changeQuantity(final AddProductDto dto) {
        final Cart cart = getCurrentCart();
        final Product product = getProduct(dto.getProduct());
        cart.changeQuantity(product, dto.getQuantity());
        return saveAndMap(cart);
    }

    @Transactional
    public CartDto remove(final int id) {
        final Cart cart = getCurrentCart();
        final Product product = getProduct(id);
        cart.removeProduct(product);
        return saveAndMap(cart);
    }

    @Transactional
    public CartDto empty() {
        final Cart cart = getCurrentCart();
        cart.empty();
        return saveAndMap(cart);
    }

    private CartDto saveAndMap(final Cart cart) {
        return cartMapper.map(repository.save(cart), CartDto.class);
    }

    private Product getProduct(final int id) {
        final Product product = productRepository.findOne(id);
        if (product == null) {
            throw new ProductNotFoundException();
        }
        return product;
    }

    private Cart getCurrentCart() {
        Cart cart = repository.findOne(1);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        return cart;
    }

    private Cart getMockedCart() {
        //FIXME mocked for one cart only User/Session controlled cart is ideal
        Cart cart = repository.findOne(1);
        if (cart == null) {
            cart = new Cart();
            cart.setId(1);
        }
        return cart;
    }

}
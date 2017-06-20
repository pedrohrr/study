package org.pedrohrr.ecomm.ecommerce.service;

import org.pedrohrr.ecomm.ecommerce.dto.ProductDto;
import org.pedrohrr.ecomm.ecommerce.entity.Product;
import org.pedrohrr.ecomm.ecommerce.exception.EmptyResultException;
import org.pedrohrr.ecomm.ecommerce.exception.ProductNotFoundException;
import org.pedrohrr.ecomm.ecommerce.mapper.ProductMapper;
import org.pedrohrr.ecomm.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for PRODUCT
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    /**
     * List all existing products
     * @return list of products
     */
    public List<ProductDto> list() {
        final List<Product> products = repository.findAll();

        if (CollectionUtils.isEmpty(products)) {
            throw new EmptyResultException();
        }

        return mapper.mapAsList(products, ProductDto.class);
    }

    /**
     * Retrieves one product by its id
     * @param id - product id
     * @return product found
     */
    public ProductDto one(final int id) {
        final Product product = repository.findOne(id);

        if (product == null) {
            throw new ProductNotFoundException();
        }

        return mapper.map(product, ProductDto.class);
    }

    /**
     * Saves the given product
     * @param product - product to be saved
     * @return product saved
     */
    @Transactional
    public ProductDto save(final ProductDto product) {
        final Product entity = mapper.map(product, Product.class);
        return mapper.map(repository.save(entity), ProductDto.class);
    }

    /**
     * Deletes a product by the given id
     * @param id - product id
     */
    @Transactional
    public void delete(final int id) {
        repository.delete(id);
    }

}
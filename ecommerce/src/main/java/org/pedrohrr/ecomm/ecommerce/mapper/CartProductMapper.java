package org.pedrohrr.ecomm.ecommerce.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.pedrohrr.ecomm.ecommerce.dto.CartDto;
import org.pedrohrr.ecomm.ecommerce.dto.CartProductDto;
import org.pedrohrr.ecomm.ecommerce.entity.Cart;
import org.pedrohrr.ecomm.ecommerce.entity.CartProduct;
import org.springframework.stereotype.Component;

@Component
public class CartProductMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(CartProduct.class, CartProductDto.class)
                .field("product", "product")
                .field("quantity", "quantity")
                .byDefault().register();
    }

}
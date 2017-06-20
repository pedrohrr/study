package org.pedrohrr.ecomm.ecommerce.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.pedrohrr.ecomm.ecommerce.dto.CartDto;
import org.pedrohrr.ecomm.ecommerce.entity.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Cart.class, CartDto.class)
                .field("id","id")
                .field("products", "products")
                .field("openedAt", "openedAt")
                .byDefault().register();
    }
}
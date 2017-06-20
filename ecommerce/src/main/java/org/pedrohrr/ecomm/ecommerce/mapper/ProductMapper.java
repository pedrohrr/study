package org.pedrohrr.ecomm.ecommerce.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.pedrohrr.ecomm.ecommerce.dto.ProductDto;
import org.pedrohrr.ecomm.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Product.class, ProductDto.class)
                .field("id","id")
                .field("name", "name")
                .field("price", "price")
                .byDefault()
                .register();
    }

}
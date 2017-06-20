package org.pedrohrr.ecomm.ecommerce.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.pedrohrr.ecomm.ecommerce.dto.ProductDto;
import org.pedrohrr.ecomm.ecommerce.entity.Product;
import org.pedrohrr.ecomm.ecommerce.mapper.ProductMapper;
import org.pedrohrr.ecomm.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductMapper mapper;

    public final Product product = Mockito.mock(Product.class);
    public final List<Product> products = Arrays.asList(product);
    public final ProductDto dto = Mockito.mock(ProductDto.class);
    public final List<ProductDto> dtos = Arrays.asList(dto);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void list() throws Exception {
        Mockito.when(repository.findAll()).thenReturn(products);
        Mockito.when(mapper.mapAsList(products, ProductDto.class)).thenReturn(dtos);
        Assert.assertEquals(dtos, service.list());
    }

    @Test
    public void one() throws Exception {
        Mockito.when(repository.findOne(1)).thenReturn(product);
        Mockito.when(mapper.map(product, ProductDto.class)).thenReturn(dto);
        Assert.assertEquals(dto, service.one(1));
    }

    @Test
    public void save() throws Exception {
        Mockito.when(mapper.map(dto, Product.class)).thenReturn(product);
        Mockito.when(repository.save(product)).thenReturn(product);
        Mockito.when(mapper.map(product, ProductDto.class)).thenReturn(dto);
        Assert.assertEquals(dto, service.save(dto));
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
    }

}
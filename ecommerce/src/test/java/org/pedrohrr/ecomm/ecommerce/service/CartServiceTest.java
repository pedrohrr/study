package org.pedrohrr.ecomm.ecommerce.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.pedrohrr.ecomm.ecommerce.dto.AddProductDto;
import org.pedrohrr.ecomm.ecommerce.dto.CartDto;
import org.pedrohrr.ecomm.ecommerce.entity.Cart;
import org.pedrohrr.ecomm.ecommerce.entity.Product;
import org.pedrohrr.ecomm.ecommerce.mapper.CartMapper;
import org.pedrohrr.ecomm.ecommerce.repository.CartRepository;
import org.pedrohrr.ecomm.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CartServiceTest {

    @InjectMocks
    private CartService service;

    @Mock
    private ProductService productService;

    @Mock
    private CartRepository repository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CartMapper cartMapper;

    public final AddProductDto dto = Mockito.mock(AddProductDto.class);
    public final Cart cart = Mockito.mock(Cart.class);
    public final Product product = Mockito.mock(Product.class);
    public final CartDto cartDto = Mockito.mock(CartDto.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Mockito.when(dto.getProduct()).thenReturn(1);
        Mockito.when(dto.getQuantity()).thenReturn(1);

        Mockito.when(repository.findOne(1)).thenReturn(cart);
        Mockito.when(productRepository.findOne(1)).thenReturn(product);
        Mockito.when(repository.save(cart)).thenReturn(cart);
        Mockito.when(cartMapper.map(cart, CartDto.class)).thenReturn(cartDto);
    }

    @Test
    public void add() throws Exception {
        Assert.assertEquals(cartDto, service.add(dto));
    }

    @Test
    public void changeQuantity() throws Exception {
        Assert.assertEquals(cartDto, service.changeQuantity(dto));
    }

    @Test
    public void remove() throws Exception {
        Assert.assertEquals(cartDto, service.remove(1));
    }

    @Test
    public void empty() throws Exception {
        Assert.assertEquals(cartDto, service.empty());
    }

}
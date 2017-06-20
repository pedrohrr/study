package org.pedrohrr.ecomm.ecommerce.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CartDto {

    private Integer id;
    private List<CartProductDto> products;
    private String openedAt;

}
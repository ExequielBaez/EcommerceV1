package com.ecommerce.EcommerceV1.controller.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductDTO {

    private String idProduct;

    private String nameProduct;

    private String code;

    private String description;

    private String urlImage;

    private BigDecimal price;

    private String idUser;

    private String idCategory;
}

package com.ecommerce.EcommerceV1.service;

import com.ecommerce.EcommerceV1.controller.dto.ProductDTO;
import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(String idProduct);

    ProductDTO createProduct(ProductEntity productEntity);

    void disableProduct(String idProduct);
}

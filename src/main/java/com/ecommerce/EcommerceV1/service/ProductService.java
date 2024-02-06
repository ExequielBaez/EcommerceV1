package com.ecommerce.EcommerceV1.service;

import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(String idProduct);

    ProductEntity createProduct(ProductEntity productEntity);

    void disableProduct(String idProduct);
}

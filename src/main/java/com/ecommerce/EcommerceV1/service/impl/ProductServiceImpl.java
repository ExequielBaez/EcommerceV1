package com.ecommerce.EcommerceV1.service.impl;

import com.ecommerce.EcommerceV1.exceptions.RegisterNotFound;
import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;
import com.ecommerce.EcommerceV1.persistance.entity.UserEntity;
import com.ecommerce.EcommerceV1.persistance.repository.ProductRepository;
import com.ecommerce.EcommerceV1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> productList = productRepository.findAllEnable();
        return productList;
    }

    @Override
    public ProductEntity getProductById(String idProduct) {
        ProductEntity productEntity = productRepository.findById(idProduct).orElseThrow();

        return productEntity;
    }

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void disableProduct(String idProduct) {
        ProductEntity product = productRepository.findById(idProduct)
                .orElseThrow( () -> new RegisterNotFound("User Not Found with id " +idProduct));

        product.setEnabled(false);

        productRepository.save(product);
    }
}

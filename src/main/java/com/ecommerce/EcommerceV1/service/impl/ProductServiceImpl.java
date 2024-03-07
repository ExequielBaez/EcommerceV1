package com.ecommerce.EcommerceV1.service.impl;

import com.ecommerce.EcommerceV1.controller.dto.ProductDTO;
import com.ecommerce.EcommerceV1.exceptions.RegisterNotFound;
import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;
import com.ecommerce.EcommerceV1.persistance.mappers.ProductMapper;
import com.ecommerce.EcommerceV1.persistance.repository.ProductRepository;
import com.ecommerce.EcommerceV1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productList = productMapper.toProductDTOList(productRepository.findAllEnable());
        return productList;
    }

    @Override
    public ProductDTO getProductById(String idProduct) {
        ProductDTO productDTO = productMapper.toProductDto(productRepository.findById(idProduct).orElseThrow());

        return productDTO;
    }

    @Override
    public ProductDTO createProduct(ProductEntity productEntity) {
        return productMapper.toProductDto(productRepository.save(productEntity));
    }

    @Override
    public void disableProduct(String idProduct) {
        ProductEntity product = productRepository.findById(idProduct)
                .orElseThrow( () -> new RegisterNotFound("User Not Found with id " +idProduct));

        product.setEnabled(false);

        productRepository.save(product);
    }
}

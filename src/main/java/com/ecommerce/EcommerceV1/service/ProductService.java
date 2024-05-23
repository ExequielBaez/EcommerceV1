package com.ecommerce.EcommerceV1.service;

import com.ecommerce.EcommerceV1.controller.dto.ProductDTO;
import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(String idProduct);

    ProductDTO createProduct(ProductDTO productDTO, MultipartFile multipartFile) throws IOException;

    void disableProduct(String idProduct);
}

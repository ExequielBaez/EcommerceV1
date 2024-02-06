package com.ecommerce.EcommerceV1.controller;


import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;
import com.ecommerce.EcommerceV1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){

        List<ProductEntity> productEntityList = productService.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(productEntityList);
    }

    @GetMapping("{idProduct}")
    public ResponseEntity<?> getProductById(@PathVariable String idProduct){

        ProductEntity productEntity = productService.getProductById(idProduct);

        return ResponseEntity.status(HttpStatus.OK).body(productEntity);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductEntity productEntity){

        ProductEntity product = productService.createProduct(productEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("{idProduct}")
    public ResponseEntity<?> disableProduct(@PathVariable String idProduct){

        productService.disableProduct(idProduct);

        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}


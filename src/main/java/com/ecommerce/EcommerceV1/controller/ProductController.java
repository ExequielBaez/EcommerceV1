package com.ecommerce.EcommerceV1.controller;


import com.ecommerce.EcommerceV1.controller.dto.ProductDTO;
import com.ecommerce.EcommerceV1.persistance.entity.CategoryEntity;
import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;
import com.ecommerce.EcommerceV1.service.CategoryService;
import com.ecommerce.EcommerceV1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/api/product")
@CrossOrigin(value = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){

        List<ProductDTO> productDTOList = productService.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }

    @GetMapping("{idProduct}")
    public ResponseEntity<?> getProductById(@PathVariable String idProduct){

        ProductDTO productDTO = productService.getProductById(idProduct);

        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestParam("idProduct") String idProduct,
                                           @RequestParam("code") String code,
                                           @RequestParam("nameProduct") String nameProduct,
                                           @RequestParam("description") String description,
                                           @RequestParam("price") BigDecimal price,
                                           @RequestParam("urlImage") String urlImage,
                                           @RequestParam(value = "image", required = false)MultipartFile multipartFile,
                                           @RequestParam("idCategory") String idCategory,
                                           @RequestParam("idUser") String idUser

                                           ) throws IOException {

        ProductDTO product = new ProductDTO();

        product.setIdProduct(idProduct);
        product.setNameProduct(nameProduct);
        product.setDescription(description);
        product.setPrice(price);
        product.setCode(code);
        product.setUrlImage(urlImage);
        product.setIdCategory(idCategory);
        product.setIdUser(idUser);



        ProductDTO productDTO = productService.createProduct(product, multipartFile);

        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @DeleteMapping("{idProduct}")
    public ResponseEntity<?> disableProduct(@PathVariable String idProduct){

        productService.disableProduct(idProduct);

        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}


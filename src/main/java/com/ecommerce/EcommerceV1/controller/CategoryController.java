package com.ecommerce.EcommerceV1.controller;

import com.ecommerce.EcommerceV1.persistance.entity.CategoryEntity;
import com.ecommerce.EcommerceV1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/api/category")
@CrossOrigin(value = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        List<CategoryEntity> categoryList = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categoryList);
    }

    @GetMapping("{idCategory}")
    public ResponseEntity<?> getCategoryById(@PathVariable String idCategory){
        CategoryEntity categoryEntity = categoryService.getCategoryById(idCategory);
        return ResponseEntity.status(HttpStatus.OK).body(categoryEntity);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryEntity categoryEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryEntity));

    }

    @PutMapping
    public ResponseEntity<?> disableCategory(@PathVariable String idCategory){

        categoryService.disableCategory(idCategory);

        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

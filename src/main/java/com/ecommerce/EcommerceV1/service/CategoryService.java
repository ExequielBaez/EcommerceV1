package com.ecommerce.EcommerceV1.service;

import com.ecommerce.EcommerceV1.persistance.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity getCategoryById(String idCategory);

    List<CategoryEntity> getAllCategories();

    Object createCategory(CategoryEntity categoryEntity);

    void disableCategory(String idCategory);
}

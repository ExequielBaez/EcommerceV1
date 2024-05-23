package com.ecommerce.EcommerceV1.service.impl;

import com.ecommerce.EcommerceV1.controller.dto.ProductDTO;
import com.ecommerce.EcommerceV1.exceptions.RegisterNotFound;
import com.ecommerce.EcommerceV1.persistance.entity.CategoryEntity;
import com.ecommerce.EcommerceV1.persistance.repository.CategoryRepository;
import com.ecommerce.EcommerceV1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategories() {

        List<CategoryEntity> categoryList = categoryRepository.findAllEnable();
        return categoryList;
    }
    @Override
    public CategoryEntity getCategoryById(String idCategory) {

        CategoryEntity category = categoryRepository.findById(idCategory).orElseThrow();
        return category;
    }

    @Override
    public Object createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public void disableCategory(String idCategory) {

        CategoryEntity category = categoryRepository.findById(idCategory)
                .orElseThrow( () -> new RegisterNotFound("Category Not Found with id " +idCategory));

        category.setEnabled(false);

        categoryRepository.save(category);

    }
}

package com.ecommerce.EcommerceV1.persistance.repository;

import com.ecommerce.EcommerceV1.persistance.entity.CategoryEntity;
import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

    @Query(value = "SELECT * FROM category_entity WHERE enabled = 1", nativeQuery = true)
    List<CategoryEntity> findAllEnable();
}

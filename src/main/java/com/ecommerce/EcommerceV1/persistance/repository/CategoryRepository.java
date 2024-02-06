package com.ecommerce.EcommerceV1.persistance.repository;

import com.ecommerce.EcommerceV1.persistance.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}

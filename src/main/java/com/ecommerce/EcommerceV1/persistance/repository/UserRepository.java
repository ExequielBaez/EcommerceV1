package com.ecommerce.EcommerceV1.persistance.repository;

import com.ecommerce.EcommerceV1.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}

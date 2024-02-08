package com.ecommerce.EcommerceV1.persistance.repository;

import com.ecommerce.EcommerceV1.persistance.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}

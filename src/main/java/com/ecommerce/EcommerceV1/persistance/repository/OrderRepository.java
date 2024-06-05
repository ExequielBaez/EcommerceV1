package com.ecommerce.EcommerceV1.persistance.repository;

import com.ecommerce.EcommerceV1.enums.OrderState;
import com.ecommerce.EcommerceV1.persistance.entity.OrderEntity;
import com.ecommerce.EcommerceV1.persistance.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE order_entity SET order_state = :state WHERE id_Order = :idOrder", nativeQuery = true)
    void updateStateById(String idOrder, String state);

    List<OrderEntity> findByUserEntity(UserEntity userEntity);


}

package com.ecommerce.EcommerceV1.service;

import com.ecommerce.EcommerceV1.enums.OrderState;
import com.ecommerce.EcommerceV1.persistance.entity.OrderEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getAllorders();

    OrderEntity getOrderById(String idOrder);

    OrderEntity save(OrderEntity orderEntity);

    List<OrderEntity> findByUserId(String idUser);

    void updateStateById(String idOrder, String state);
}

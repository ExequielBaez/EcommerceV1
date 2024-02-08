package com.ecommerce.EcommerceV1.service.impl;

import com.ecommerce.EcommerceV1.persistance.entity.OrderEntity;
import com.ecommerce.EcommerceV1.persistance.repository.OrderRepository;
import com.ecommerce.EcommerceV1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAllorders() {
        List<OrderEntity> orderList = orderRepository.findAll();
        return orderList;
    }

    @Override
    public OrderEntity getOrderById(String idOrder) {

        OrderEntity order = orderRepository.findById(idOrder).orElseThrow();
        return order;    }

    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }
}
